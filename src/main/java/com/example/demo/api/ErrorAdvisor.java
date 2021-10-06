package com.example.demo.api;

import com.example.demo.exception.BaseException;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

//เกิดerror แล้วจะทำยังไง?
@ControllerAdvice
public class ErrorAdvisor {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(BaseException e) {
        ErrorResponse err = new ErrorResponse();
        //getMessage From defult Exception Java
        err.setError(e.getMessage());
        err.setStatus(HttpStatus.EXPECTATION_FAILED.value());
        return new ResponseEntity<>(err, HttpStatus.EXPECTATION_FAILED);
    }

    @Data
    public static class ErrorResponse{
        private LocalDateTime timestemp = LocalDateTime.now();
        private int status;
        private String error;

    }
}
