package com.example.demo.exception;

public class UserException extends BaseException {

    public UserException(String code) {
        super("user " + code );
    }

    public static UserException emailNull(){
        return new UserException("register.email.null");
    }

    public static UserException requestNull(){
        return new UserException("register.email.null");
    }
}
