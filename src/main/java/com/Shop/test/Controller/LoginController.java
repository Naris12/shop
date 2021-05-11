package com.Shop.test.Controller;

import com.Shop.test.Model.LoginModel;
import com.Shop.test.Service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/login2")
public class LoginController {
    private final LoginService loginService;

    @PostMapping
    public String testlogin(@RequestBody LoginModel loginModel){
       return loginService.login(loginModel);
    }
}
