package com.order.service;

import com.order.request.OrderRequest;
import com.order.response.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse placeOrder(String userId, OrderRequest orderRequest);

    OrderResponse getOrder(String userId,Long orderId);

    List<OrderResponse> getOrders(String userId);
}
