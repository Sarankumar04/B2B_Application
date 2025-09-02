package com.order.model;

import com.order.util.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "orders")
@Setter
@Getter
@NoArgsConstructor
public class Order {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    @Column(nullable = false)
    private String userId;
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @Column(name = "order_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime orderDate;
    @Column(name = "updated_date")
    @UpdateTimestamp
    private LocalDateTime updatedDate;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @Column(name = "user_email",nullable = false)
    private String userEmail;
    @Column(name = "phone_number",nullable = false)
    private Long phoneNumber;
    @Column(name = "orderItem")
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

}
