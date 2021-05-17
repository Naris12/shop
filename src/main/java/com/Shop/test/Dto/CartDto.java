package com.Shop.test.Dto;


import lombok.Data;

import java.util.List;

@Data
public class CartDto {


    private List<CartItemDto> cartItem;
    private double totalCost;
    public CartDto() {
    }



    public CartDto(List<CartItemDto> cartItem, double totalCost) {
        this.cartItem = cartItem;
        this.totalCost = totalCost;
    }


}
