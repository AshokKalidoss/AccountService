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

    String message() default "User Id invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
