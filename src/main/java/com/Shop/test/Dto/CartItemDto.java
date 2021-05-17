package com.Shop.test.Dto;

import com.Shop.test.Model.CartModel;
import com.Shop.test.Model.ProductsModel;
import lombok.Data;

@Data
public class CartItemDto {
    private Long Cartid;
    private Long id;
    private Integer quantity;
    private ProductsModel productsModel;

    public CartItemDto() {
    }

    public CartItemDto(CartModel cartModel){
        this.setCartid(cartModel.getCartid());
        this.setId(cartModel.getId());
        this.setQuantity(cartModel.getQuantity());
        this.setProductsModel(cartModel.getProductsModel());
    }
}
