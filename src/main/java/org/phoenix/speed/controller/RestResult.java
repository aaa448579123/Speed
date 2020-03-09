package org.phoenix.speed.controller;


import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletResponse;
import java.io.IOException;

public class RestResult {
    private Integer code;
    private Object data;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public RestResult setResultCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        return this;
    }

    public RestResult setRestException(RestException restException) {
        this.code = restException.getCode();
        this.message = restException.getMessage();
        return this;
    }

    public static RestResult success(){
        RestResult restResult = new RestResult();
        restResult.setResultCode(ResultCode.SUCCESS);
        return restResult;
    }

    public static RestResult success(Object o){
        RestResult restResult = new RestResult();
        restResult.setResultCode(ResultCode.SUCCESS);
        restResult.setData(o);
        return restResult;
    }

    public static RestResult error(RestException restException){
        RestResult restResult = new RestResult();
        restResult.setRestException(restException);
        return restResult;
    }

    public static void writeResponse(ServletResponse response,ResultCode resultCode) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");
        RestResult restResult = new RestResult().setResultCode(resultCode);
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(restResult));
        response.getWriter().flush();
    }

    public static void writeResponse(ServletResponse response,RestException restException) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");
        RestResult restResult = new RestResult().setRestException(restException);
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(restResult));
        response.getWriter().flush();
    }
}
