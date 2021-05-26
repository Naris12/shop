package com.Shop.test.Controller;

import com.Shop.test.Model.ProductsModel;
import com.Shop.test.Model.UserModel;
import com.Shop.test.Service.ProductsService;
import com.Shop.test.repostitory.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductsController {

    private final ProductsRepository productsRepository;
    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsRepository productsRepository, ProductsService productsService) {
        this.productsRepository = productsRepository;
        this.productsService = productsService;
    }

    @GetMapping
    @RequestMapping("/{productId}")
    public Optional<ProductsModel> getproductbyid(@PathVariable("productId") Long productId){
       return productsRepository.findById(productId);

    }
    @GetMapping("/all")
    public List<ProductsModel>getallproduct(ProductsModel productsModel){
        return productsService.getallproduct();
    }


    @PostMapping("/add")
    public void addproduct(@RequestBody ProductsModel productsModel){
        if(Objects.isNull(productsModel.getProductUrl())){
            productsModel.setProductUrl("http://blog.sogoodweb.com/upload/510/ZDqhSBYemO.jpg");
        }
        productsService.addProduct(productsModel.getProductname(), productsModel.getProductdescription(),
                productsModel.getProductprice(),productsModel.getProductUrl());
    }


    @PutMapping("/update")
    public void update(@RequestBody ProductsModel productsModel){
        productsService.updateproduct(productsModel);
    }

    @DeleteMapping("/delete/{productid}")
    public ResponseEntity<UserModel> deletproduct(@PathVariable("productid")Long productid){
        productsService.deleteproduct(productid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
