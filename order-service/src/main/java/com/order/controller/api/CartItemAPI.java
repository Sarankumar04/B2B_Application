package com.order.controller.api;

import com.order.request.CartItemRequest;
import com.order.response.CartItemResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public interface CartItemAPI {

    @PostMapping(value = "/cart-items", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CartItemResponse> addCartItem(@RequestHeader(value = "userId") String userId, @RequestBody @Valid CartItemRequest cartItem);

}
