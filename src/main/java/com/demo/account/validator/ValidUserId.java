package com.demo.account.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {UserIdValidator.class}
)
public @interface ValidUserId {

    String message() default "Invalid user id. User Id is a number and must not be greater than 10 digits";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
