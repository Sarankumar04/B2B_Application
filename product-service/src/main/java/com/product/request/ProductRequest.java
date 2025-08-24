package com.product.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ProductRequest {
    @NotEmpty
    private String productName;
    @NotEmpty
    private Double price;
    private String description;
    private Integer stockQuantity;
    @NotEmpty
    private String category;
    private String imageUrl;
}
