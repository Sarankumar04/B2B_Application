package com.product.service.impl;

import com.product.repository.ProductRepository;
import com.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ModelMapper modelMapper;
}
