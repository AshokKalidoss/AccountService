package com.demo.account.validator;

import com.demo.account.exception.InvalidAccountNumberException;
import com.demo.account.util.Constants;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AccountNumberValidator implements ConstraintValidator<ValidAccountNumber, String> {

    @Override
    public void initialize(ValidAccountNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(String accountNumber, ConstraintValidatorContext ctx) {
        boolean isValid = accountNumber != null && accountNumber.length() >= 1
                && accountNumber.length() <= Constants.ACCT_NUM_LENGTH
                && accountNumber.trim().matches(Constants.ACCT_NUM_REGEX);

        if (!isValid) {
            throw new InvalidAccountNumberException("Invalid account number. Account number can contain only numeric digits with an optiona '-' symbol " +
                    "and must not exceed 16 characters", "9003");
        }

        return isValid;
    }
}
