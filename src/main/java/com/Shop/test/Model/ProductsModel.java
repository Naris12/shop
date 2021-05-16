package com.Shop.test.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class ProductsModel {
    @Id
    @SequenceGenerator(
            name = "products_sequence",
            sequenceName ="products_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "products_sequence"
    )
    private Long productId;
    private String productname;
    private String productdescription;
    private Double productprice;

    public ProductsModel() {
    }

    public ProductsModel(String productname, String productdescription, Double productprice) {
        this.productname = productname;
        this.productdescription = productdescription;
        this.productprice = productprice;
    }


}
