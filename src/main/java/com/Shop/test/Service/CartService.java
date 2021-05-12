package com.Shop.test.Service;

import com.Shop.test.Model.CartModel;
import com.Shop.test.Model.LoginModel;
import com.Shop.test.Model.ProductsModel;
import com.Shop.test.Model.UserModel;
import com.Shop.test.repostitory.CartRepository;
import com.Shop.test.repostitory.ProductsRepository;
import com.Shop.test.repostitory.UserRepository;
import com.Shop.test.util.SecurityUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductsRepository productsRepository;



    public void addnewproducttocart( ProductsModel productsModel){

        Optional<Long> opt = SecurityUtil.getcurrentUserId();

        if(opt.isEmpty()){
            throw new IllegalStateException("no user id");
        }
        Long aLong = opt.get();

        Optional<UserModel> userid = userRepository.findById(aLong);
        if(userid.isEmpty()){
            throw new IllegalStateException("user id not found");

        }
        UserModel userModel = userid.get();


        Optional<ProductsModel> productid = productsRepository.findById(2L);

        ProductsModel productsModel1 = productid.get();



        CartModel cartModel = new CartModel();
        cartModel.setProductsModel(productsModel1);
        cartModel.setUserModel(userModel);
        cartModel.setQuantity(3);

        Double total=productsModel1.getProductprice()*cartModel.getQuantity();
        cartModel.setTotalprice(total);


        cartRepository.save(cartModel);


    }
}
