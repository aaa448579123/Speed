package org.phoenix.speed.exception.exceptions.global;

import org.phoenix.speed.exception.RestException;

/**
 * 无访问权限
 * @author qinzhihui
 */
public class NoAuthenticationException extends RestException {
    public NoAuthenticationException() {
        super(GlobalExceptionErrorCode.NoAuthorizationExceptionErrorCode, "无访问权限");
    }
    public NoAuthenticationException(String message) {
        super(GlobalExceptionErrorCode.NoAuthorizationExceptionErrorCode, message);
    }
}
