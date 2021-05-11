package com.Shop.test.Controller;

import com.Shop.test.Model.ProductsModel;
import com.Shop.test.Service.ProductsService;
import com.Shop.test.repostitory.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @GetMapping
    public List<ProductsModel>getallproduct(ProductsModel productsModel){
        return productsService.getallproduct();
    }


    @PostMapping
    public void addproduct(@RequestBody ProductsModel productsModel){
        productsService.addProduct(productsModel.getProductname(), productsModel.getProductdescription(),
                productsModel.getProductprice());
    }
}
