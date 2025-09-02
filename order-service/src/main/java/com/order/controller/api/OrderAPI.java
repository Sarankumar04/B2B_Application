package com.order.controller.api;

import com.order.request.OrderRequest;
import com.order.response.OrderResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

public interface OrderAPI {

    @PostMapping(value = "/orders/place-order",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<OrderResponse> placeOrder(
            @RequestHeader(value = "userId") @NotEmpty String userId,
            @Valid @RequestBody
            OrderRequest orderRequest
    );

    @GetMapping(value = "/orders",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<OrderResponse>> getOrders(
            @RequestHeader(value = "userId") @NotEmpty String userId
    );
}
