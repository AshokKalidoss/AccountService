package com.demo.account.exception;

import lombok.Getter;
import lombok.Setter;

public class InvalidAccountNumberException extends RuntimeException{

    @Setter
    @Getter
    private String errorCode;

    public InvalidAccountNumberException(String errorMessage, String errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
    }
}
