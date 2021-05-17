package com.Shop.test.repostitory;

import com.Shop.test.Model.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartModel,Long> {

    List<CartModel> findAllById(Long id);
}
