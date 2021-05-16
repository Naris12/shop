package com.Shop.test.Controller;

import com.Shop.test.Dto.CartDto;
import com.Shop.test.Model.CartModel;
import com.Shop.test.Model.UserModel;
import com.Shop.test.Service.CartService;
import com.Shop.test.Service.ProductsService;
import com.Shop.test.repostitory.CartRepository;
import com.Shop.test.repostitory.UserRepository;
import com.Shop.test.util.SecurityUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
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
        /*List<CartModel> allById = cartRepository.findAllById(id);
        return allById;*/
        Optional<Long> opt = SecurityUtil.getcurrentUserId();
        if(opt.isEmpty()){
            throw new IllegalStateException("opt is null");
        }

        Long aLong = opt.get();

        Optional<UserModel> userid = userRepository.findById(aLong);
        UserModel userModel = userid.get();

        CartDto cartDto= cartService.listCartItem(userModel.getId());
        return  new ResponseEntity<CartDto>(cartDto, HttpStatus.OK);
    }



}
