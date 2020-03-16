package org.phoenix.speed.exception.exceptions.global;

/**
 * 全局异常错误码
 * @author qinzhihui
 */
public abstract class GlobalExceptionErrorCode {
    //系统错误
    public static final Integer SystemExceptionErrorCode = 500;
    //未找到请求
    public static final Integer NotFoundExceptionErrorCode = 404;
    //无访问权限
    public static final Integer NoAuthorizationExceptionErrorCode = 1000;
    //身份验证失败
    public static final Integer NoAuthenticationExceptionErrorCode = 1001;
    //未登录
    public static final Integer UnLoginException = 403;

}
