package com.product.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ProductRequest {
    @NotEmpty
    private String productName;
    @NotNull
    private Double price;
    private String description;
    private Integer stockQuantity;
    @NotEmpty
    private String category;
    @NotEmpty
    private String owner;
    private String imageUrl;
}
