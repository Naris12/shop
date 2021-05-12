package com.Shop.test.Model;

import lombok.Data;
import org.apache.catalina.User;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Cart")
public class CartModel {

    @Id
    @SequenceGenerator(
            name = "cart_sequence",
            sequenceName = "cart_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_sequence"
    )
    private Long cartid;
    @ManyToOne
    @JoinColumn(name = "id")
    private UserModel userModel;

    @ManyToOne
    @JoinColumn(name = "productid")
    private ProductsModel productsModel;


    private int quantity;
    private Double totalprice;







}
