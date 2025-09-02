package com.order.service.impl;

import com.order.client.UserClient;
import com.order.exception.EmptyCartItemsException;
import com.order.model.Order;
import com.order.model.OrderItem;
import com.order.repository.OrderRepository;
import com.order.request.OrderRequest;
import com.order.response.CartItemResponse;
import com.order.response.OrderItemResponse;
import com.order.response.OrderResponse;
import com.order.response.UserResponse;
import com.order.service.CartItemService;
import com.order.service.OrderService;
import com.order.util.OrderStatus;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final UserClient userClient;
    private final ModelMapper mapper;
    private final OrderRepository orderRepository;
    private final CartItemService cartItemService;

    @Override
    public OrderResponse placeOrder(String userId, OrderRequest orderRequest) {
        ResponseEntity<UserResponse> userResponse = userClient.getUserById(userId);

        List<CartItemResponse> cartItemResponses = cartItemService.getCartItems(userId);
        if (cartItemResponses == null || cartItemResponses.isEmpty()) {
            throw new EmptyCartItemsException("Your cart is empty . Please add product to cart");
        }

        Order order = new Order();
        order.setOrderStatus(OrderStatus.PENDING);
        order.setUserId(userId);
        order.setPhoneNumber(orderRequest.getPhoneNumber());
        order.setUserEmail(orderRequest.getUserEmail());
        order.setOrderItems(cartItemResponses.stream().map(item -> mapper.map(item, OrderItem.class)).toList());
        BigDecimal totalPrice = cartItemResponses.stream().map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()))).reduce(BigDecimal.ZERO, BigDecimal::add);

        order.setTotalAmount(totalPrice);

        Order savedOrder = orderRepository.save(order);
        OrderResponse orderResponse = mapper.map(savedOrder, OrderResponse.class);
        orderResponse.setOrderItemResponses(order.getOrderItems().stream().map(orderItem -> mapper.map(orderItem, OrderItemResponse.class)).toList());
        orderResponse.setOrderItemResponses(orderResponse.getOrderItemResponses().stream().peek(item -> item.setSubTotal(item.getPrice().multiply(new BigDecimal(item.getQuantity())))).toList());

        cartItemService.clearCartItems(userId);

        return orderResponse;
    }

    @Override
    public OrderResponse getOrder(String userId, Long orderId) {
        ResponseEntity<UserResponse> userResponse = userClient.getUserById(userId);
        Order order = orderRepository.findByUserIdAndOrderId(userId, orderId).orElseThrow();
        OrderResponse response = mapper.map(order, OrderResponse.class);
        response.setOrderItemResponses(order.getOrderItems().stream().map(orderItem -> mapper.map(orderItem, OrderItemResponse.class)).toList());
        return response;
    }

    @Override
    public List<OrderResponse> getOrders(String userId) {
        ResponseEntity<UserResponse> userResponse = userClient.getUserById(userId);
        List<Order> orders =orderRepository.findByUserId(userId);

        return orders.stream().map(order -> {
                    OrderResponse response = mapper.map(order, OrderResponse.class);
                    response.setOrderItemResponses(order.getOrderItems().stream().map(item -> mapper.map(item, OrderItemResponse.class)).toList());
                    return response;
                })
                .toList();
    }
}
