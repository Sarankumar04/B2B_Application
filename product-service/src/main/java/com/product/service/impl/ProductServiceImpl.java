package com.product.service.impl;

import com.product.exception.ProductNotFoundException;
import com.product.model.Product;
import com.product.repository.ProductRepository;
import com.product.request.Filter;
import com.product.request.ProductRequest;
import com.product.response.ProductResponse;
import com.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public List<ProductResponse> getAllProducts(Filter filter) {

        Sort.Direction direction = filter.getSortType()==1? Sort.Direction.ASC:Sort.Direction.DESC;
        Sort sort = Sort.by(direction, filter.getFiledName());
        Pageable page = PageRequest.of(Integer.parseInt(filter.getPageNumber())-1,Integer.parseInt(filter.getPageSize()),sort);

        return repository.findAll(page)
                .stream()
                .map(product -> modelMapper.map(product, ProductResponse.class))
                .toList();
    }
}
