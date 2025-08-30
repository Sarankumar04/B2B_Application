package com.order.client;

import com.order.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", path = "/api/v1/products")
public interface ProductClient {

    @GetMapping(path = "/{productId}")
    ResponseEntity<ProductResponse> getProduct(@PathVariable(value = "productId") Long productId);

}
