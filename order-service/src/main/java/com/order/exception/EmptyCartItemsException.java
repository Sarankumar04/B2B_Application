package com.order.exception;

public class EmptyCartItemsException extends RuntimeException {
    public EmptyCartItemsException(String message) {
        super(message);
    }
}
