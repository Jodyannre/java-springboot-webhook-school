package com.allstudent.data.exception.validator;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameStartValidator.class)
public @interface NameStart {
    String startChar() default "_";
    String message() default "Name must start with _";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
