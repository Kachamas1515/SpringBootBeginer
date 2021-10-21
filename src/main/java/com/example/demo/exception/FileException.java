package com.example.demo.exception;

public class FileException extends BaseException {

    public FileException(String code) {
        super("user " + code);
    }

    public static FileException fileNull() {
        return new FileException("null");
    }

    public static FileException fileMaxSize() {
        return new FileException("MaxSize");
    }

    public static FileException fileUnSupport() {
        return new FileException("UnSupport.ContentType");
    }
}
