package org.phoenix.speed.controller.exceptions.global;

import org.phoenix.speed.controller.RestException;

/**
 * 无访问权限
 * @author qinzhihui
 */
public class NoAuthenticationException extends RestException {
    public NoAuthenticationException() {
        super(GlobalExceptionErrorCode.NotFoundExceptionErrorCode, "无访问权限");
    }
    public NoAuthenticationException(String message) {
        super(GlobalExceptionErrorCode.NoAuthenticationExceptionErrorCode, message);
    }
}
