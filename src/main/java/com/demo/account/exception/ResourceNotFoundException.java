package com.demo.account.exception;

import lombok.Getter;
import lombok.Setter;


public class ResourceNotFoundException  extends RuntimeException{

    public static final String ERROR_CODE = "1001";

    @Setter
    @Getter
    private String errorCode;

    public ResourceNotFoundException(String errorMessage) {
        super(errorMessage);
        this.errorCode = ERROR_CODE;
    }

    public ResourceNotFoundException(String errorMessage, String errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
    }


}
