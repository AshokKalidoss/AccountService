package com.demo.account.validator;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class UserIdValidator implements ConstraintValidator<ValidUserId, String> {

    public static final String USER_ID_REGEX ="[0-9]+";
    public static final int USER_ID_MAX_LENGTH = 10;
    public static final int USER_ID_MIN_LENGTH = 1;


    @Override
    public void initialize(ValidUserId constraintAnnotation) {
    }

    @Override
    public boolean isValid(String userId, ConstraintValidatorContext ctx) {
        boolean isValid = userId != null && userId.length() >= USER_ID_MIN_LENGTH
                && userId.length() <= USER_ID_MAX_LENGTH
                && userId.trim().matches(USER_ID_REGEX);

        log.info("Is userId a valid number --> {}",isValid);

        return isValid;
    }
}
