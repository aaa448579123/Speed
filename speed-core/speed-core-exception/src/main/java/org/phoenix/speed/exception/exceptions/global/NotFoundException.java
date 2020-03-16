package org.phoenix.speed.exception.exceptions.global;


import org.phoenix.speed.exception.RestException;

/**
 * 未找到请求
 * @author qinzhihui
 */
public class NotFoundException extends RestException {
    public NotFoundException() {
        super(GlobalExceptionErrorCode.NotFoundExceptionErrorCode, "未找到该请求");
    }
    public NotFoundException(String message) {
        super(GlobalExceptionErrorCode.NotFoundExceptionErrorCode, message);
    }
}
