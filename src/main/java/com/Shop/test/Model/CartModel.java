package com.Shop.test.Model;


import com.Shop.test.Dto.AddtoCartDto;
import com.Shop.test.Dto.CartDto;
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
<<<<<<< HEAD

    @Column(name = "id")
    private Long id;


=======
    @Column(name = "id")
    private Long id;

>>>>>>> 19cc2252e0256480ccbea32aca8784da066c9ae8
    @Column(name = "productId")
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "product")
    private ProductsModel productsModel;


    private int quantity;
    private Double totalprice;


    public CartModel() {

    }




}
