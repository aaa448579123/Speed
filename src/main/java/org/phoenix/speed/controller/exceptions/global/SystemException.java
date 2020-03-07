package org.phoenix.speed.controller.exceptions.global;

import org.phoenix.speed.controller.RestException;

/**
 * 系统错误
 * @author qinzhihui
 */
public class SystemException extends RestException {

    public SystemException() {
        super(GlobalExceptionErrorCode.SystemExceptionErrorCode, "系统错误");
    }

    public SystemException(String message) {
        super(GlobalExceptionErrorCode.SystemExceptionErrorCode, message);
    }
}
