package com.product.controller;

import com.product.controller.api.ProductAPI;
import com.product.request.ProductRequest;
import com.product.response.ProductResponse;
import com.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController implements ProductAPI {

    private final ProductService productService;

    @Override
    public ResponseEntity<ProductResponse> createProduct(ProductRequest product) {
        ProductResponse productResponse = productService.createProduct(product);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ProductResponse> updateProduct(ProductRequest productRequest, Long productId) {
        ProductResponse productResponse = productService.updateProduct(productRequest,productId);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductResponse> getProduct(Long productId) {
        ProductResponse productResponse = productService.getProduct(productId);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteProduct(Long productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>("Successfully deleted the product", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductResponse>> getAllProducts(String searchText) {
        List<ProductResponse> products = productService.getAllProducts(searchText);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
