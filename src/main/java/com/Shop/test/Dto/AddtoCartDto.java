package com.Shop.test.Dto;

import com.Shop.test.Model.CartModel;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AddtoCartDto {
    private Long cartid;
    private @NotNull Long id;
    private @NotNull Long productId;
    private @NotNull Integer quantity;

    public AddtoCartDto() {
    }
    /*public AddtoCartDto(Long cartid,@NotNull Long id,@NotNull Long productId,@NotNull Integer quantity){
        this.id=id;

    }*/

   /* public AddtoCartDto(Long cartid, Long id, Long productId, Integer quantity) {
        this.cartid = cartid;
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

    public AddtoCartDto(CartModel cartModel){
        this.setCartid(cartModel.getCartid());
        this.setId(cartModel.getId());
        this.setProductId(cartModel.getProductId());
        this.setQuantity(cartModel.getQuantity());
    }*/
}
