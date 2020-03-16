package org.phoenix.speed.exception.exceptions.global;


import org.phoenix.speed.exception.RestException;

public class UnLoginException extends RestException {
    public UnLoginException() {
        super(GlobalExceptionErrorCode.UnLoginException, "未登录");
    }

    public UnLoginException(String message) {
        super(GlobalExceptionErrorCode.UnLoginException, message);
    }
}
