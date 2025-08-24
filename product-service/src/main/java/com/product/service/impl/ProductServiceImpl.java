package com.product.service.impl;

import com.product.exception.ProductNotFoundException;
import com.product.model.Product;
import com.product.repository.ProductRepository;
import com.product.request.ProductRequest;
import com.product.response.ProductResponse;
import com.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public ProductResponse createProduct(ProductRequest product) {
        Product prod = modelMapper.map(product, Product.class);
        int id = ThreadLocalRandom.current().nextInt(100000, 1000000);
        prod.setProductId((long) id);
        repository.save(prod);
        return modelMapper.map(prod, ProductResponse.class);
    }

    @Override
    public ProductResponse updateProduct(ProductRequest productRequest, Long productId) {
        Product product = repository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product doesn't exit"));
        product.setProductName(productRequest.getProductName());
        product.setDescription(productRequest.getDescription());
        product.setCategory(productRequest.getCategory());
        product.setPrice(productRequest.getPrice());
        product.setStockQuantity(productRequest.getStockQuantity());
        product.setImageUrl(productRequest.getImageUrl());
        repository.save(product);
        return modelMapper.map(product, ProductResponse.class);
    }

    @Override
    public ProductResponse getProduct(Long productId) {
        Product product = repository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product doesn't exit"));
        return modelMapper.map(product, ProductResponse.class);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = repository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product doesn't exit"));
        repository.delete(product);
    }

    @Override
    public List<ProductResponse> getAllProducts(String searchText) {
        List<Product> products = repository.findBySearch(searchText);
        return products.stream().map(product -> modelMapper.map(product, ProductResponse.class)).toList();
    }
}
