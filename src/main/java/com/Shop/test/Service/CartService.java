package com.Shop.test.Service;
import com.Shop.test.Dto.CartDto;
import com.Shop.test.Dto.CartItemDto;
import com.Shop.test.Model.CartModel;
import com.Shop.test.Model.ProductsModel;
import com.Shop.test.Model.UserModel;
import com.Shop.test.repostitory.CartRepository;
import com.Shop.test.repostitory.ProductsRepository;
import com.Shop.test.repostitory.UserRepository;
import com.Shop.test.util.SecurityUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Data
@AllArgsConstructor
@Service
@Transactional
public class CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductsRepository productsRepository;








    public CartModel addnewproducttocart( ProductsModel productsModel,Integer quantity,Long productId){


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

        Long productId1 = productId;

        Optional<ProductsModel> byId = productsRepository.findById(productId1);
        ProductsModel productsModel1 = byId.get();

        Optional<ProductsModel> productid = productsRepository.findById(productId1);






        CartModel cartModel = new CartModel();
        cartModel.setId(userModel.getId());
        cartModel.setProductId(productsModel1.getProductId());
        cartModel.setProductsModel(productsModel1);
        cartModel.setQuantity(quantity);


        Double total=productsModel1.getProductprice()*cartModel.getQuantity();
        cartModel.setTotalprice(total);


        return cartRepository.save(cartModel);


    }

    public void findcart(){
        Optional<Long> opt = SecurityUtil.getcurrentUserId();
        if(opt.isEmpty()){
            throw new IllegalStateException("no user id");
        }

        Long aLong = opt.get();
        Optional<UserModel> userid = userRepository.findById(aLong);
        if(userid.isEmpty()) {
            throw new IllegalStateException("no user id");
        }
        UserModel userModel = userid.get();




    }

    public CartDto listCartItem(Long id){
        Optional<Long> aLong = SecurityUtil.getcurrentUserId();
        Long aLong1 = aLong.get();
        Optional<UserModel> userid = userRepository.findById(aLong1);
        if(userid.isEmpty()){
            throw new IllegalStateException("user id not found");

        }
        UserModel userModel = userid.get();

        List<CartModel> cartModelById = cartRepository.findCartModelById(userModel.getId());
        List<CartItemDto>cartItem= new ArrayList<>();
        for(CartModel cartModel:cartModelById){
            CartItemDto cartItemDto=getDtoFromCart(cartModel);
            cartItem.add(cartItemDto);
        }

        double totocost=0;

        for(CartItemDto cartItemDto:cartItem){
            totocost+=(cartItemDto.getProductsModel().getProductprice()*cartItemDto.getQuantity());

        }
        CartDto cartDto=new CartDto(cartItem,totocost);
        return cartDto;

    }






    public static CartItemDto getDtoFromCart(CartModel cartModel){
        CartItemDto cartItemDto=new CartItemDto(cartModel);
        return  cartItemDto;
    }












}
