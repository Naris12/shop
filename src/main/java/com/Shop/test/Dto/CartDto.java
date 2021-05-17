package com.Shop.test.Dto;

<<<<<<< HEAD

import com.Shop.test.Model.CartModel;
import com.Shop.test.Model.ProductsModel;
=======
>>>>>>> 19cc2252e0256480ccbea32aca8784da066c9ae8
import lombok.Data;

import java.util.List;

@Data
public class CartDto {
<<<<<<< HEAD
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
=======
  private List<CartItemDto> cartItem;
  public Double totalCost;

    public CartDto() {
    }

    public CartDto(List<CartItemDto>cartItem,double totalCost){
        this.cartItem =cartItem;
        this.totalCost=totalCost;
>>>>>>> 19cc2252e0256480ccbea32aca8784da066c9ae8
    }
}
