package com.orders.exception;

/**
 * @Description: 系统内部异常
 * @Author liuyang
 * @Date 2020/6/9 19:51
 */
public class SystemException extends RuntimeException {

    private String code;

    public String getCode() {
        return code;
    }

    public SystemException() {

    }

    public SystemException(String code, String message) {
        super(message);
        this.code = code;
    }

    public SystemException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
