package org.phoenix.speed.controller;

/**
 * Rest接口异常返回超类
 * @author qinzhihui
 */
public class RestException extends RuntimeException{
    protected Integer code ;
    protected Object data ;
    public RestException(Integer code,String message,Object data,Throwable e){
        super(message,e);
        this.code = code ;
        this.data = data ;
    }

    public RestException(Integer code,String message,Object data){
        this(code,message,data,null);
    }

    public RestException(Integer code,String message){
        this(code,message,null,null);
    }

    public RestException(String message,Throwable e){
        this(null,message,null,e);
    }

    public RestException(){

    }

    public RestException(Throwable e){
        super(e);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
