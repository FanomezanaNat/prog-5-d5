package com.hei.model.exception;

public class CoffeeNotFoundException extends RuntimeException {
    public CoffeeNotFoundException(String message) {
        super(message);
    }
}
