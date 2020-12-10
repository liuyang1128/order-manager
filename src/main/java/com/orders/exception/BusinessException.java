package com.orders.exception;

/**
 * @Description:
 * @Author liuyang
 * @Date 2020/6/9 19:51
 */
public class BusinessException extends RuntimeException {

    private String code;

    public String getCode() {
        return code;
    }

    public BusinessException() {

    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
