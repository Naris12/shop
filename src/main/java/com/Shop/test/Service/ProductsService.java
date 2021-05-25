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

    public ProductsModel addProduct(String productname,String productdescription,Double productprice,String producturl){
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
        if(Objects.isNull(productsModel.getProductUrl())){
            productsModel.setProductUrl("http://blog.sogoodweb.com/upload/510/ZDqhSBYemO.jpg");
        }
        productsModel.setProductUrl(producturl);
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
