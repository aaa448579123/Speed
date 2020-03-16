package org.phoenix.speed.exception.exceptions.global;


import org.phoenix.speed.exception.RestException;

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
