package org.phoenix.speed.redis.exception;

/**
 * 业务逻辑异常
 * @author yangzhenjiang
 * @version 1.0
 * @description
 * @date 2020/4/21 16:43
 */
public class ServiceException extends RuntimeException{

    private String code;
    private String msg;

    public ServiceException() {
    }

    public ServiceException(String msg) {
        this.msg = msg;
    }

    public ServiceException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
