package com.demo.account.validator;

import com.demo.account.exception.InvalidUserIdException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserIdValidator implements ConstraintValidator<ValidUserId, String> {

    @Override
    public void initialize(ValidUserId constraintAnnotation) {

    }

    @Override
    public boolean isValid(String userId, ConstraintValidatorContext ctx) {
         boolean isValid =  userId !=null && userId.length() >=1
                 && userId.length() <= 10
                 && userId.trim().matches("[0-9]+");

         if(!isValid) {
             throw new InvalidUserIdException("Invalid user id. User Id is a number and must not be greater than 10 digits", "9002");
         }

         return isValid;
    }
}
