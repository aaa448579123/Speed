package org.phoenix.speed.controller.exceptions.global;

import org.phoenix.speed.controller.RestException;

public class UnLoginException extends RestException {
    public UnLoginException() {
        super(GlobalExceptionErrorCode.UnLoginException, "未登录");
    }

    public UnLoginException(String message) {
        super(GlobalExceptionErrorCode.UnLoginException, message);
    }
}
