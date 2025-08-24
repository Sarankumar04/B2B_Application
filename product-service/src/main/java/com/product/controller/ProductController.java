package com.product.controller;

import com.product.controller.api.ProductAPI;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductController implements ProductAPI {
}
