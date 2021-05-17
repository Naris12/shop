package com.Shop.test.repostitory;

import com.Shop.test.Model.CartModel;
import com.Shop.test.Model.UserModel;
import com.Shop.test.util.SecurityUtil;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<CartModel,Long> {


    List<CartModel>findCartModelById(Long id);
}
