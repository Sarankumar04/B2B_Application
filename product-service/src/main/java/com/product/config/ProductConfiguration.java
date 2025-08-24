package com.product.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {

    @Bean
    ModelMapper defaultModelMapperBean() {
        return new ModelMapper();
    }
}
