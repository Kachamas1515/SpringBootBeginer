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

    //Create//
    public static UserException createEmail(){
        return new UserException("create.email.null");
    }

    public static UserException createPassword(){
        return new UserException("create.password.null");
    }

    public static UserException createName(){
        return new UserException("create.name.null");
    }

    public static UserException createEmailDuplicated(){
        return new UserException("create.email.duplicated");
    }

}
