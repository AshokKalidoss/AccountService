package com.demo.account.validator;

import com.demo.account.exception.InvalidUserIdException;
import com.demo.account.util.Constants;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class UserIdValidator implements ConstraintValidator<ValidUserId, String> {

    @Override
    public void initialize(ValidUserId constraintAnnotation) {
    }

    @Override
    public boolean isValid(String userId, ConstraintValidatorContext ctx) {
        boolean isValid = userId != null && userId.length() >= 1
                && userId.length() <= Constants.USER_ID_LENGTH
                && userId.trim().matches(Constants.USER_ID_REGEX);

        log.info("Is userId a valid number --> {}",isValid);

      /* if (!isValid) {
            throw new InvalidUserIdException("Invalid user id. User Id is a number and must not be greater than 10 digits", "9002");
        }*/

        return isValid;
    }
}
