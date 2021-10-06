package com.example.demo.business;

import com.example.demo.exception.BaseException;
import com.example.demo.exception.ProductException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductBusiness {

    public String getProductById(String id) throws BaseException {
        //JPA
        if (Objects.equals("1234", id)) {
            throw ProductException.notfound();
        }
        return id;
    }
}
