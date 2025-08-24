package com.product.service;

import com.product.request.ProductRequest;
import com.product.response.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest product);

    ProductResponse updateProduct(ProductRequest productRequest, Long productId);

    ProductResponse getProduct(Long productId);

    void deleteProduct(Long productId);

    List<ProductResponse> getAllProducts(String searchText);
}
