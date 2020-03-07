package org.phoenix.speed.controller;

import org.phoenix.speed.controller.exceptions.global.NotFoundException;
import org.phoenix.speed.controller.exceptions.global.SystemException;
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
    public RestResult notFoundException(){
        return RestResult.error(new NotFoundException());
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
