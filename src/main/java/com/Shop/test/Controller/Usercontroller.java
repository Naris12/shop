package com.Shop.test.Controller;

import com.Shop.test.Model.UserModel;
import com.Shop.test.Service.Userservice;
import com.Shop.test.repostitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class Usercontroller {

    private final UserRepository userRepository;
    private final Userservice userservice;


    @Autowired
    public Usercontroller(UserRepository userRepository, Userservice userservice) {
        this.userRepository = userRepository;
        this.userservice = userservice;
    }




    @GetMapping
    public List<UserModel> getalluser() {
        return userRepository.findAll();
    }


    @PostMapping
    public void addnewuser(@RequestBody UserModel userModel) {
        userservice.addnewuser(userModel.getName(), userModel.getEmail(), userModel.getPassword());
    }

    @GetMapping("/refresh-token")
    public ResponseEntity<String >refresh(){
        String token = userservice.refreshToken();
        return ResponseEntity.ok(token);
    }


}
