package com.company.Validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MinZNOValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})

public @interface MinZNO {
    String message() default "{lab2.src.com.company.Validator.MinZNOValidator.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int value();
}
