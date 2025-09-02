package com.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(exception = ProductAlreadyExistInCart.class)
    ResponseEntity<String> productAlreadyExistInCartExceptionHandler(ProductAlreadyExistInCart ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(exception = EmptyCartItemsException.class)
    ResponseEntity<String> emptyCartItemsExceptionHandler(EmptyCartItemsException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
