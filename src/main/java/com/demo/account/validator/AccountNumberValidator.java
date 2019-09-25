package com.demo.account.validator;

import com.demo.account.exception.InvalidAccountNumberException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AccountNumberValidator implements ConstraintValidator<ValidAccountNumber, String> {

    @Override
    public void initialize(ValidAccountNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(String accountNumber, ConstraintValidatorContext ctx) {
        boolean isValid =  accountNumber !=null && accountNumber.length() >=1
                && accountNumber.length() <= 16
                && accountNumber.trim().matches("[0-9-]+");

        if(!isValid) {
            throw new InvalidAccountNumberException("Invalid account number. Account number is Number with an option - symbol and cannot exceed 16 characters", "9003");
        }

        return isValid;
    }
}
