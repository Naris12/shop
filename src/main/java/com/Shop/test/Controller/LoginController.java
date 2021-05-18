package com.Shop.test.Controller;

import com.Shop.test.Service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@AllArgsConstructor
@RestController
@RequestMapping("/login2")
public class LoginController {
    private final LoginService loginService;

    @PostMapping
    public RedirectView testlogin(String email, String password){
       loginService.login(email, password);
       return new RedirectView("/index");

    }
}
