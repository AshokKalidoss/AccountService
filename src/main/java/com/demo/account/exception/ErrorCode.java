package com.demo.account.exception;

public enum ErrorCode {

    ACCOUNT_NOT_FOUND_ERROR("1000", "No valid account found for the user: "),
    TRANSACTION_NOT_FOUND_ERROR("1001","No valid transactions found for the account: " ),
    VALIDATION_ERROR("1002", "Invalid input"),
    INTERNAL_SERVER_ERROR("9001", "Unexpected Error");

    public final String code;
    public final String message;

    private ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
