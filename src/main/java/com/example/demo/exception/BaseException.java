package com.example.demo.exception;

public abstract class BaseException extends Exception {

    public BaseException(String code) {
        //Use Exception of Java
        super(code);
    }
}
