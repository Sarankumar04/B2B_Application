package com.order.controller;

import com.order.controller.api.CartItemAPI;
import com.order.request.CartItemRequest;
import com.order.response.CartItemResponse;
import com.order.service.CartItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CartItemController implements CartItemAPI {


    private final CartItemService cartItemService;

    @Override
    public ResponseEntity<CartItemResponse> addCartItem(String userId, CartItemRequest cartItem) {

        CartItemResponse response = cartItemService.addCartItem(userId,cartItem);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
