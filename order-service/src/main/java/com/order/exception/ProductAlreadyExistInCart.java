package com.order.exception;

public class ProductAlreadyExistInCart extends RuntimeException {
    public ProductAlreadyExistInCart(String message) {
        super(message);
    }
}
