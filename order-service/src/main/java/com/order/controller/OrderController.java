package com.order.controller;

import com.order.controller.api.OrderAPI;
import com.order.request.OrderRequest;
import com.order.response.OrderResponse;
import com.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderController implements OrderAPI {

    private final OrderService orderService;

    @Override
    public ResponseEntity<OrderResponse> placeOrder(String userId, OrderRequest orderRequest) {
        OrderResponse orderResponse = orderService.placeOrder(userId,orderRequest);
        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<OrderResponse>> getOrders(String userId) {
        List<OrderResponse> responses = orderService.getOrders(userId);
        return new ResponseEntity<>(responses,HttpStatus.OK);
    }
}
