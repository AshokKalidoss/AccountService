package com.demo.account.exception;

import lombok.Getter;
import lombok.Setter;


public class ResourceNotFoundException extends RuntimeException {

    @Setter
    @Getter
    private String errorCode;

    public ResourceNotFoundException(String errorMessage, String errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
    }


}
