package com.Shop.test.Service;

import com.Shop.test.Model.UserModel;
import com.Shop.test.repostitory.UserRepository;
import com.Shop.test.util.SecurityUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class Userservice {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;


    public List<UserModel> getalluser() {
        return userRepository.findAll();
    }

    public UserModel addnewuser(String name, String email, String password) {

        if (Objects.isNull(name) || name.length() == 0) {
            throw new IllegalStateException("name null");
        }

        if (Objects.isNull(password) || password.length() == 0) {
            throw new IllegalStateException("password null");
        }

        Optional<UserModel> findbyEmail = userRepository.findByemail(email);
        if (findbyEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        if (Objects.isNull(email) || email.length() == 0) {
            throw new IllegalStateException("email null");
        }
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setPassword(passwordEncoder.encode(password));
        userModel.setEmail(email);
        userRepository.save(userModel);
        return userModel;

    }

    public boolean mactchpassword(String rawpassword, String encodepassword) {
        return passwordEncoder.matches(rawpassword, encodepassword);
    }

    public Optional<UserModel> findbyid(Long id) {
        return userRepository.findById(id);
    }


    public String refreshToken() {
        Optional<Long> opt = SecurityUtil.getcurrentUserId();
        if (opt.isEmpty()) {
            throw new IllegalStateException("opt null");
        }
        Long userid = opt.get();
        Optional<UserModel> optUser = findbyid(userid);
        if (opt.isEmpty()) {
            throw new IllegalStateException("null");
        }
        UserModel userModel = optUser.get();
        return tokenService.tokenize(userModel);

    }
}
