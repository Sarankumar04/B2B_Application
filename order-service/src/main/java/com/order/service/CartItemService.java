package com.order.service;

import com.order.request.CartItemRequest;
import com.order.response.CartItemResponse;

import java.util.List;

public interface CartItemService {
    CartItemResponse addCartItem(String userId, CartItemRequest cartItem);

    List<CartItemResponse> getCartItems(String userId);

    boolean clearCartItems(String userId);
}
