package com.welcome.controller;

import com.welcome.Result.Result;
import com.welcome.exception.BusinessException;
import com.welcome.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(SystemException.class)
    public Result SystemException(SystemException e){
        return new Result(e.getCode(),e.getMessage());
    }
    @ExceptionHandler(BusinessException.class)
    public Result BusinessException(BusinessException e){
        return new Result(e.getCode(),e.getMessage());
    }
}
