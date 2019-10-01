package com.demo.account.validator;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class AccountNumberValidator implements ConstraintValidator<ValidAccountNumber, String> {

    public static final String ACCT_NUM_REGEX ="[0-9-]+";
    public static final int ACCT_NUM_MAX_LENGTH = 16;
    public static final int ACCT_NUM_MIN_LENGTH = 1;



    @Override
    public void initialize(ValidAccountNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(String accountNumber, ConstraintValidatorContext ctx) {

        boolean isValid = accountNumber != null && accountNumber.length() >= ACCT_NUM_MIN_LENGTH
                && accountNumber.length() <= ACCT_NUM_MAX_LENGTH
                && accountNumber.trim().matches(ACCT_NUM_REGEX);

        return isValid;
    }
}
