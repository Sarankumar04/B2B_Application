package com.order.response;

import com.order.util.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderResponse {
    private Long orderId;
    private BigDecimal totalAmount;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private String userEmail;
    private Long phoneNumber;
    private List<OrderItemResponse> orderItemResponses;
}
