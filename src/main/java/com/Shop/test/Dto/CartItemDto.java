package com.Shop.test.Dto;

import com.Shop.test.Model.CartModel;
import com.Shop.test.Model.ProductsModel;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CartItemDto {
    private Long Cartid;
    private @NotNull Long id;
    private @NotNull Integer quantity;
    private @NotNull
    ProductsModel productsModel;

    public CartItemDto() {
    }

    public CartItemDto(CartModel cartModel) {
     this.setCartid(cartModel.getCartid());
     this.setId(cartModel.getId());
     this.setQuantity(cartModel.getQuantity());
     this.setProductsModel(cartModel.getProductsModel());
    }
}