package com.demo.account.exception;

import lombok.Getter;
import lombok.Setter;

public class InvalidUserIdException extends RuntimeException {

    @Setter
    @Getter
    private String errorCode;

    public InvalidUserIdException(String errorMessage, String errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
    }
}
