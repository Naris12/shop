package com.Shop.test.Controller;

import com.Shop.test.Model.LoginModel;
import com.Shop.test.Model.LoginResponse;
import com.Shop.test.Service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@AllArgsConstructor
@RestController
@RequestMapping("/login2")
public class LoginController {
    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<LoginResponse> testlogin(@RequestBody LoginModel loginModel){
        LoginResponse response = loginService.login(loginModel);

        return  ResponseEntity.ok(response);


    }
}
