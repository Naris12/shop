package com.Shop.test.config.token;

import com.Shop.test.Service.TokenService;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TokenFilter extends GenericFilterBean {
    private final TokenService tokenService;

    public TokenFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        String authorization = request1.getHeader("Authorization");

        if (ObjectUtils.isEmpty(authorization)) {
            chain.doFilter(request, response);
            return;
        }

        if (!authorization.startsWith("Bearer")) {
            chain.doFilter(request, response);
            return;
        }

        String token = authorization.substring(7);
        DecodedJWT decoded = tokenService.verify(token);
        if (decoded == null) {
            chain.doFilter(request, response);
            return;
        }
        //Userid
        Long principal = decoded.getClaim("principal").asLong();


        String role = decoded.getClaim("role").asString();

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));


        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(principal,
                "(protected)", authorities);

        SecurityContext contextHolder = SecurityContextHolder.getContext();
        contextHolder.setAuthentication(authenticationToken);
        chain.doFilter(request, response);

    }

}
