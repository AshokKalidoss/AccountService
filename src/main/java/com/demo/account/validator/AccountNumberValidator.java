package com.demo.account.validator;

import com.demo.account.exception.InvalidAccountNumberException;
import com.demo.account.util.Constants;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class AccountNumberValidator implements ConstraintValidator<ValidAccountNumber, String> {

    @Override
    public void initialize(ValidAccountNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(String accountNumber, ConstraintValidatorContext ctx) {
       /* boolean isValid;
        if(accountNumber != null && accountNumber.length() >= 1
                && accountNumber.length() <= Constants.ACCT_NUM_LENGTH
                && accountNumber.trim().matches(Constants.ACCT_NUM_REGEX))
        {
            isValid = true;
            return isValid;
        }else{
            throw new InvalidAccountNumberException("Invalid account number. Account number can contain only numeric digits with an optiona '-' symbol " +
                    "and must not exceed 16 characters", "9003");
        }*/
        boolean isValid = accountNumber != null && accountNumber.length() >= 1
                && accountNumber.length() <= Constants.ACCT_NUM_LENGTH
                && accountNumber.trim().matches(Constants.ACCT_NUM_REGEX);

        return isValid;
    }
}
