package com.invilen.order.exception;

public class BusinessException extends RuntimeException{
    public BusinessException(String msg) {
        super(msg);
    }
}
