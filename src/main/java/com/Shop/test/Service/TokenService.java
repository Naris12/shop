package com.Shop.test.Service;

import com.Shop.test.Model.UserModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Service
public class TokenService {
    @Value("${app.token.secret}")
    private String secret;

    @Value("${app.token.issuer}")
    private String issuer;

    public  String tokenize(UserModel userModel){



        Calendar calendar = Calendar.getInstance();
        calendar.add(calendar.MINUTE,60);
        Date expiresAT=calendar.getTime();
       // LocalDateTime expiresAt = LocalDateTime.now().plusMinutes(60);


        return JWT.create()
                .withIssuer(issuer)
                .withClaim("principal",userModel.getId())
                .withClaim("role","USER")
                .withExpiresAt(expiresAT)
                .sign(algorithm());

    }

    private Algorithm algorithm(){
        return Algorithm.HMAC256(secret);
    }

    public DecodedJWT verify(String token){
        try{
            JWTVerifier verifier = JWT.require(algorithm())
                    .withIssuer(issuer)
                    .build();
         return   verifier.verify(token);

        }catch (Exception e){
            return null;
        }

    }
}
