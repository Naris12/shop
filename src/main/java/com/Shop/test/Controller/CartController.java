package com.Shop.test.Controller;

import com.Shop.test.Dto.CartDto;
import com.Shop.test.Model.CartModel;
<<<<<<< HEAD
import com.Shop.test.Model.UserModel;
import com.Shop.test.Service.CartService;
import com.Shop.test.Service.ProductsService;
=======
import com.Shop.test.Model.ProductsModel;
import com.Shop.test.Model.UserModel;
import com.Shop.test.Service.CartService;
>>>>>>> 19cc2252e0256480ccbea32aca8784da066c9ae8
import com.Shop.test.repostitory.CartRepository;
import com.Shop.test.repostitory.UserRepository;
import com.Shop.test.util.SecurityUtil;
import lombok.AllArgsConstructor;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

=======
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

>>>>>>> 19cc2252e0256480ccbea32aca8784da066c9ae8
@AllArgsConstructor
@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
<<<<<<< HEAD
    private  final CartRepository cartRepository;
    private final ProductsService productsService;
    private  final UserRepository userRepository;


    @PostMapping
    public CartModel addnewproducttocart(@RequestBody CartModel cartModel){
        return cartService.addnewproducttocart(cartModel.getProductsModel(), cartModel.getProductId(), cartModel.getQuantity());
    }

    @GetMapping("/all")
    public List<CartModel> getallcart(CartModel cartModel){
      return   cartRepository.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDto> findallbyid(@PathVariable("id")Long id){

        Optional<Long> opt = SecurityUtil.getcurrentUserId();
        if(opt.isEmpty()){
            throw new IllegalStateException("opt is null");
        }

        Long aLong = opt.get();

        Optional<UserModel> userid = userRepository.findById(aLong);
        UserModel userModel = userid.get();

        CartDto cartDto= cartService.listCartItem(userModel.getId());
        return  new ResponseEntity<CartDto>(cartDto, HttpStatus.OK);
=======
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    /*@PostMapping
    public void addnewproducttocart(UserModel userModel, ProductsModel productsModel,Integer quantity,Long productId){
       cartService.addnewproducttocart(productsModel,quantity,productId);
    }*/

    @PostMapping
    public CartModel addnewproducttocart2(@RequestBody CartModel cartModel){
       return cartService.addnewproducttocart(cartModel.getProductsModel(),cartModel.getQuantity(),cartModel.getProductId());
    }

    @GetMapping("/all")
    public List<CartModel>getllcart(){
        return cartRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDto> findcart(@PathVariable("id")UserModel id){
        Optional<Long> opt = SecurityUtil.getcurrentUserId();
        if(opt.isEmpty()){
            throw new IllegalStateException("opt null");
        }
        Long aLong = opt.get();
        Optional<UserModel> byId = userRepository.findById(aLong);
        UserModel userModel = byId.get();

        CartDto cartDto = cartService.listCartItem(userModel.getId());
        return new ResponseEntity<CartDto>(cartDto, HttpStatus.OK);
>>>>>>> 19cc2252e0256480ccbea32aca8784da066c9ae8
    }



}
