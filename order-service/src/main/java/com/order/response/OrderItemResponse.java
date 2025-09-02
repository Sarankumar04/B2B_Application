package com.order.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class OrderItemResponse {
    private Long productId;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal subTotal;
}
