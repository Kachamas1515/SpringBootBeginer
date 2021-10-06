package com.example.demo.exception;

public class ProductException extends BaseException{

    public ProductException(String code) {
        super("product" + code);
    }

    public static ProductException notfound(){
        return new ProductException(".notfound.id");
    }
}
