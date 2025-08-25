package com.product.repository;

import com.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true, value = " select * from products where products.product_name LIKE CONCAT('%',:searchText,'%') or products.description LIKE CONCAT('%',:searchText,'%')")
    List<Product> findBySearch(@Param(value = "searchText") String searchText);
}
