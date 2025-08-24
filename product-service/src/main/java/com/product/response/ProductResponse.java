package com.product.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ProductResponse {
    private Long productId;
    private String productName;
    private Double price;
    private String owner;
    private String description;
    private Integer stockQuantity;
    private String category;
    private String imageUrl;
}
