package com.product.repository;

import com.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true, value = " select * from products where products.name like('%:searchText%') or products.description like('%:searchText%')")
    List<Product> findBySearch(String searchText);
}
