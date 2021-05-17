package com.Shop.test.repostitory;

import com.Shop.test.Model.CartModel;
import com.Shop.test.Model.UserModel;
import com.Shop.test.util.SecurityUtil;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> 19cc2252e0256480ccbea32aca8784da066c9ae8

@Repository
public interface CartRepository extends JpaRepository<CartModel,Long> {

<<<<<<< HEAD
    List<CartModel> findAllById(Long id);
=======

    List<CartModel>findCartModelById(Long id);
>>>>>>> 19cc2252e0256480ccbea32aca8784da066c9ae8
}
