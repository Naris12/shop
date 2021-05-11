package com.Shop.test.Service;

import com.Shop.test.Model.ProductsModel;
import com.Shop.test.repostitory.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public ProductsModel addProduct(String productname,String productdescription,String productprice){
        if(Objects.isNull(productname)){
            throw new IllegalStateException("product name null");
        }
        if(Objects.isNull(productdescription)){
            throw new IllegalStateException("product description null");
        }
        if(Objects.isNull(productprice)){
            throw new IllegalStateException("product price null");
        }

        ProductsModel productsModel=new ProductsModel();
        productsModel.setProductname(productname);
        productsModel.setProductdescription(productdescription);
        productsModel.setProductprice(productprice);
        productsRepository.save(productsModel);

        return productsModel;
    }

    public List<ProductsModel>getallproduct(){
         return productsRepository.findAll();
    }
    public long getproductbyid(Long productid){
        return productid;
    }
}
