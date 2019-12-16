package com.orders.exception;

/**
 * Created by zc on 2018/4/10.
 */
public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}
