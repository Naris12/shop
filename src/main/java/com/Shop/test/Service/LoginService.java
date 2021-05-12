package com.Shop.test.Service;

import com.Shop.test.Model.LoginModel;
import com.Shop.test.Model.UserModel;
import com.Shop.test.repostitory.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@AllArgsConstructor
@Service
public class LoginService {
    private final UserRepository userRepository;
    private final Userservice userservice;
    private final TokenService tokenService;

    public String login(LoginModel loginModel){
        Optional<UserModel> opt = userRepository.findByemail(loginModel.getEmail());
        if(opt.isEmpty()){
            throw new IllegalStateException("login fail");
        }
        UserModel userModel=opt.get();

        if(!userservice.mactchpassword(loginModel.getPassword(),userModel.getPassword())){
            throw new IllegalStateException("login fail2");
        }
        String token = tokenService.tokenize(userModel);

        return token;


    }
}