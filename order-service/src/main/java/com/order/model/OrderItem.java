/*
package com.order.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String userId;
    @Column(nullable = false)
    private Long productId;
    @Column(nullable = false)
    private BigDecimal price;
    @ManyToMany
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}
*/
