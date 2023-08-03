package com.welcome.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SystemException extends RuntimeException{
    private int code;



    public SystemException(String message, int code) {
        super(message);
        this.code = code;
    }

    public SystemException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }




}
