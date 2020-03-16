package org.phoenix.speed.exception.exceptions.user;


import org.phoenix.speed.exception.RestException;

/**
 * 未找到指定用户
 */
public class NoUserException extends RestException {
    public NoUserException(){
        super(UserErrorCode.NoUserErrorCode,"未找到指定用户");
    }
    public NoUserException(String message) {
        super(UserErrorCode.NoUserErrorCode, message);
    }
}
