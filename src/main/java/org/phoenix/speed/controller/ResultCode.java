package org.phoenix.speed.controller;

public enum ResultCode {
    SUCCESS(200,"请求成功"),
    ERROR(500,"程序出错");

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
