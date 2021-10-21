package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.BaseException;
import com.example.demo.exception.UserException;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    //action with repo

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User create(String email, String password, String name) throws BaseException {

        //validate//
        if(Objects.isNull(email)){
            throw UserException.createEmail();
        }
        if(Objects.isNull(password)){
            throw UserException.createPassword();
        }
        if(Objects.isNull(name)){
            throw UserException.createName();
        }
        //varify// (duplicate) uniqe key
        if(repo.existsByEmail(email)){
            throw UserException.createEmailDuplicated();
        }

        User entity = new User();
        entity.setEmail(email);
        entity.setPassword(password);
        entity.setName(name);

        return repo.save(entity);
    }
}
