package com.Shop.test.repostitory;

import com.Shop.test.Model.UserModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {

    Optional<UserModel>findByemail(String email);


    Optional<UserModel> findById(Long id);
}
