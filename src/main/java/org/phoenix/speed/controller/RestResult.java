package org.phoenix.speed.controller;


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

    public void setResultCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public void setRestException(RestException restException) {
        this.code = restException.getCode();
        this.message = restException.getMessage();
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
}
