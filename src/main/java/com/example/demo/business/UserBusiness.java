package com.example.demo.business;

import com.example.demo.entity.User;
import com.example.demo.exception.BaseException;
import com.example.demo.exception.FileException;
import com.example.demo.exception.UserException;
import com.example.demo.model.MRegisterRequest;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserBusiness {
    private final UserService service;

    public UserBusiness(UserService service) {
        this.service = service;
    }

    public User register(MRegisterRequest req) throws BaseException {

        User user = service.create(req.getEmail(), req.getPassword(), req.getName());

        return user;
    }

    public String uploadProfilePicture(MultipartFile file) throws BaseException {
        if(file == null){
            throw FileException.fileNull();
        }

        //size file
        if(file.getSize() > 1048576 * 2){
            throw FileException.fileMaxSize();
        }

        //type file png jpg ...
        String contentType = file.getContentType();
        if(contentType == null){
            throw FileException.fileUnSupport();
        }

        List<String> supportedTypes = Arrays.asList("image/jpeg","image/png");
        if(supportedTypes.contains(contentType)){
            throw FileException.fileUnSupport();
        }
        //using in azure cloud... //
        try {
            byte[] bytes = file.getBytes();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
