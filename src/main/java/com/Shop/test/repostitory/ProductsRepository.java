package com.Shop.test.repostitory;

import com.Shop.test.Model.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsModel,Long> {
    Optional<ProductsModel>findByProductId(Long productId);

}
