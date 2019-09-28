package com.demo.account.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {AccountNumberValidator.class}
)
public @interface  ValidAccountNumber {

    String message() default "Invalid account number. Account number can contain only numeric digits with an optional '-' symbol" +
            " and must not exceed 16 characters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
