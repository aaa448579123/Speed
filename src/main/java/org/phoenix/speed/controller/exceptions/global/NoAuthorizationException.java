package org.phoenix.speed.controller.exceptions.global;

import org.phoenix.speed.controller.RestException;

/**
 * 身份验证失败
 */
public class NoAuthorizationException extends RestException {
    public NoAuthorizationException() {
        super(GlobalExceptionErrorCode.NoAuthenticationExceptionErrorCode, "身份验证失败");
    }
    public NoAuthorizationException(String message) {
        super(GlobalExceptionErrorCode.NoAuthenticationExceptionErrorCode, message);
    }
}
