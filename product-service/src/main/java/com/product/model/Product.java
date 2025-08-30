package com.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "products")
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "product_id", unique = true, nullable = false)
    private Long productId;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "Product_price", nullable = false)
    private BigDecimal price;
    @Column(name = "description")
    private String description;
    @Column(name = "stock_quantity")
    private Integer stockQuantity;
    @Column(name = "product_owner",nullable = false)
    private String owner;
    @Column(name = "product_category")
    private String category;
    @Column(name = "active")
    private Boolean active = true;
    @Column(name = "product_image_url")
    private String imageUrl;
    @CreationTimestamp
    @Column(name = "created_date")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_date")
    private LocalDateTime updatedAt;

}
