package com.order.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartItemRequest {
    @NotNull
    private Long productId;
    @NotNull
    private Integer quantity;
}
