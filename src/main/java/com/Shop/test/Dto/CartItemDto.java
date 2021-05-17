package com.Shop.test.Dto;

import com.Shop.test.Model.CartModel;
import com.Shop.test.Model.ProductsModel;
<<<<<<< HEAD
import com.sun.istack.NotNull;
=======
>>>>>>> 19cc2252e0256480ccbea32aca8784da066c9ae8
import lombok.Data;

@Data
public class CartItemDto {
    private Long Cartid;
<<<<<<< HEAD
    private @NotNull Long id;
    private @NotNull Integer quantity;
    private @NotNull
    ProductsModel productsModel;
=======
    private Long id;
    private Integer quantity;
    private ProductsModel productsModel;
>>>>>>> 19cc2252e0256480ccbea32aca8784da066c9ae8

    public CartItemDto() {
    }

<<<<<<< HEAD

    public CartItemDto(CartModel cartModel) {
     this.setCartid(cartModel.getCartid());
     this.setId(cartModel.getId());
     this.setQuantity(cartModel.getQuantity());
     this.setProductsModel(cartModel.getProductsModel());
=======
    public CartItemDto(CartModel cartModel){
        this.setCartid(cartModel.getCartid());
        this.setId(cartModel.getId());
        this.setQuantity(cartModel.getQuantity());
        this.setProductsModel(cartModel.getProductsModel());
>>>>>>> 19cc2252e0256480ccbea32aca8784da066c9ae8
    }
}
