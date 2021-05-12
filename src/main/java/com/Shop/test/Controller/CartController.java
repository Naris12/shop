package com.Shop.test.Controller;

import com.Shop.test.Model.ProductsModel;
import com.Shop.test.Model.UserModel;
import com.Shop.test.Service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
@AllArgsConstructor
@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    @PostMapping
    public void addnewproducttocart(UserModel userModel, ProductsModel productsModel){
       cartService.addnewproducttocart(productsModel);
    }
}
