package org.phoenix.speed.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@ControllerAdvice
@Aspect
@Component
public class RestHandler implements ResponseBodyAdvice<Object> {
    @Pointcut("@within(RestApi)")
    public void classAnn() {}
    @Pointcut("@annotation(RestApi)")
    public void methodAnn() {}
    private static final String RESPONSE_REST_RESULT = "RESPONSE-REST-RESULT";

    @Before("classAnn() || methodAnn()")
    public void before(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        request.setAttribute(RESPONSE_REST_RESULT,RestResult.class);
    }
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        return request.getAttribute(RESPONSE_REST_RESULT)==null?false:true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        Object wrapperBody;
        ObjectMapper objectMapper = new ObjectMapper();
        //由于StringHttpMessageConverter加载顺序早于其他，所以返回值是String时需要单独处理
        if (o instanceof String){
            try {
                wrapperBody = objectMapper.writeValueAsString(RestResult.success(o));
            } catch (JsonProcessingException e) {
                wrapperBody = RestResult.error(o);
            }
        }else {
            wrapperBody = RestResult.success(o);
        }
        return wrapperBody;
    }
}
