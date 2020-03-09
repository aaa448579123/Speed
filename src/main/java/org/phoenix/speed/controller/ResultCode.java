package org.phoenix.speed.controller;

public enum ResultCode {
    SUCCESS(200,"请求成功"),
    UN_LOGIN(302,"未登录");

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }

}
