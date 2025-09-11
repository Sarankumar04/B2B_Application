package com.order.service.impl;

import com.order.client.ProductClient;
import com.order.client.UserClient;
import com.order.exception.ProductAlreadyExistInCart;
import com.order.model.CartItem;
import com.order.repository.CartItemRepository;
import com.order.request.CartItemRequest;
import com.order.response.CartItemResponse;
import com.order.response.ProductResponse;
import com.order.response.UserResponse;
import com.order.service.CartItemService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class CartItemImpl implements CartItemService {

    private final ProductClient productClient;
    private final UserClient userClient;
    private final CartItemRepository cartItemRepository;
    private final ModelMapper mapper;

    public CartItemResponse productServiceRetry(String userId, CartItemRequest cartItem, Throwable throwable) {
        if (throwable instanceof ProductAlreadyExistInCart exception)
            throw exception;

        System.out.println("RateLimiter Fallback due to: " + throwable.getClass().getName());
        return new CartItemResponse();
    }

    public CartItemResponse productServicer(String userId, CartItemRequest cartItem, Throwable throwable) {
        System.out.println("Retry Fallback due to: " + throwable.getClass().getName());
        return new CartItemResponse();
    }


    @Override
    @Retry(name = "productService",fallbackMethod = "productServicer")
    @RateLimiter(name = "productRateLimiter", fallbackMethod = "productServiceRetry")
    public CartItemResponse addCartItem(String userId, CartItemRequest cartItem) {

        ResponseEntity<UserResponse> user = userClient.getUserById(userId);

        ResponseEntity<ProductResponse> response = productClient.getProduct(cartItem.getProductId());

        Optional<CartItem> existCartItem = cartItemRepository.findByUserIdAndProductId(userId, cartItem.getProductId());

        if (existCartItem.isPresent()) {
            throw new ProductAlreadyExistInCart("Product Already exist in cart");
        }

        CartItem cartItemObject = new CartItem();
        cartItemObject.setPrice(response.getBody().getPrice());
        cartItemObject.setUserId(userId);
        cartItemObject.setQuantity(cartItem.getQuantity());
        cartItemObject.setProductId(cartItem.getProductId());

        cartItemRepository.save(cartItemObject);
        return mapper.map(cartItemObject, CartItemResponse.class);
    }

    @Override
    public List<CartItemResponse> getCartItems(String userId) {
        return cartItemRepository.findByUserId(userId).stream().map(item -> mapper.map(item, CartItemResponse.class)).toList();
    }

    @Override
    public boolean clearCartItems(String userId) {
        return cartItemRepository.deleteCartItemsByUserId(userId) != 0;
    }

}
