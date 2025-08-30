package com.order.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Setter
@Getter
public class ProductResponse {
    private Long productId;
    private String productName;
    private BigDecimal price;
    private String owner;
    private String description;
    private Integer stockQuantity;
    private String category;
    private String imageUrl;
}
