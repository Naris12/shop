package com.Shop.test.Controller;

import com.Shop.test.Model.UserModel;
import com.Shop.test.Service.Userservice;
import com.Shop.test.repostitory.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
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




    @GetMapping("/all")
    public List<UserModel> getalluser() {

        return userRepository.findAll();
    }




    @PostMapping("/add")
    public void addnewuser(@RequestBody UserModel userModel) {
       if(Objects.isNull(userModel.getProfileUrl())){

           userModel.setProfileUrl("https://thumbs.dreamstime.com/b/default-avatar-profile-icon-vector-social-media-user-image-182145777.jpg");

       }
        userservice.addnewuser(userModel.getName(), userModel.getEmail(), userModel.getPassword(),userModel.getProfileUrl());
    }

    @GetMapping("/refresh-token")
    public ResponseEntity<String >refresh(){
        String token = userservice.refreshToken();
        return ResponseEntity.ok(token);
    }

    @PutMapping("/update")
    public ResponseEntity<UserModel>updateuser(@RequestBody UserModel userModel){
        UserModel updateuser = userservice.updateuser(userModel);
        return new  ResponseEntity<>(updateuser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserModel>deleteuser(@PathVariable("id")Long id){
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
