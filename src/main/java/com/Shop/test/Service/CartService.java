package com.Shop.test.Service;

import com.Shop.test.Dto.AddtoCartDto;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Data
@AllArgsConstructor
@Service
public class CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductsRepository productsRepository;



    public CartModel addnewproducttocart(ProductsModel productsModel , Long productId, Integer quantity){

        //TODO:add list product to cart

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

        CartModel cartModel = new CartModel();
        cartModel.setId(userModel.getId());
        cartModel.setProductId(productsModel1.getProductId());
        cartModel.setProductsModel(productsModel1);
        cartModel.setQuantity(quantity);


        Double total=productsModel1.getProductprice()*cartModel.getQuantity();
        cartModel.setTotalprice(total);


        cartRepository.save(cartModel);


        return cartModel;
    }

   /* public List<CartModel> addtocart(CartModel cartModel) {
        Optional<Long> opt = SecurityUtil.getcurrentUserId();
        if(opt.isEmpty()){
            throw new IllegalStateException("opt null");
        }

        Long userid = opt.get();
        Optional<UserModel> uid = userRepository.findById(userid);
        UserModel userModel = uid.get();

        List<CartModel> allById = cartRepository.findAllById(userModel.getId());
        Double totalcost=0.0;
        for(CartModel cartModel1:allById){

        }

        return allById;

    }*/
    public CartDto listCartItem(Long id){
        Optional<Long> opt = SecurityUtil.getcurrentUserId();
        if(opt.isEmpty()){
            throw new IllegalStateException("opt is null");
        }

        Long aLong = opt.get();

        Optional<UserModel> userid = userRepository.findById(aLong);
        UserModel userModel = userid.get();

        List<CartModel> cartList = cartRepository.findAllById(userModel.getId());
        List<CartItemDto>cartItem=new ArrayList<>();
        for(CartModel cartModel:cartList){
         CartItemDto cartItemDto= getDtoFromCart(cartModel);
            cartItem.add(cartItemDto);
        }
        double totalcost=0;
        for(CartItemDto cartItemDto:cartItem){
            totalcost+=(cartItemDto.getProductsModel().getProductprice()*cartItemDto.getQuantity());

        }
        CartDto cartDto = new CartDto(cartItem,totalcost);
        return cartDto;


    }

   public static CartItemDto getDtoFromCart(CartModel cartModel){
      CartItemDto cartItemDtot = new CartItemDto(cartModel);
      return cartItemDtot;
   }





}
