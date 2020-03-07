package org.phoenix.speed.controller;

import org.apache.shiro.authc.AuthenticationException;
import org.phoenix.speed.controller.exceptions.global.NoAuthenticationException;
import org.phoenix.speed.controller.exceptions.global.NotFoundException;
import org.phoenix.speed.controller.exceptions.global.SystemException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletResponse;

/**
 * Rest接口异常处理类
 * @author qinzhihui
 */
@RestControllerAdvice
public class RestExceptionHandlerAdvice {

    @ExceptionHandler(NoHandlerFoundException.class)
    public RestException notFoundException(){
        return new NotFoundException();
    }

    @ExceptionHandler(AuthenticationException.class)
    public RestException authenticationException(){
        return new NoAuthenticationException();
    }

    @ExceptionHandler(BadSqlGrammarException.class)
    public RestException badSqlGrammarException(){
        return new SystemException();
    }

    @ExceptionHandler(Exception.class)
    public RestException exception(Exception exception, HttpServletResponse response) {
        RestException restException;
        if(exception instanceof RestException){
            //TODO:此处需要处理错误日志 待设计
            restException = (RestException)exception;
        }else{//未知异常
            restException = new SystemException("系统错误");
        }
        return restException;
    }
}
