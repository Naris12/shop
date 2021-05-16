package com.Shop.test.Dto;


import com.Shop.test.Model.CartModel;
import com.Shop.test.Model.ProductsModel;
import lombok.Data;

import java.util.List;

@Data
public class CartDto {
  /*  private Long cartid;
    private Long id;
    private ProductsModel productsModel;
    private Integer quantity;

    public CartDto() {
    }


    public CartDto(CartModel cartModel){
        this.setCartid(cartModel.getCartid());
        this.setId(cartModel.getId());
        this.setProductsModel(cartModel.getProductsModel());
        this.setQuantity(cartModel.getQuantity());
    }*/
    private List<CartItemDto> cartItem;
    private double totalCost;
    public CartDto() {
    }



    public CartDto(List<CartItemDto> cartItem, double totalCost) {
        this.cartItem = cartItem;
        this.totalCost = totalCost;
    }

    public List<CartItemDto>getcartItem(){
        return cartItem;
    }
}
