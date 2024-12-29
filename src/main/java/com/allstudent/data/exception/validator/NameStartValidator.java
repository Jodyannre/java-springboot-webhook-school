package com.allstudent.data.exception.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameStartValidator implements ConstraintValidator<NameStart, String> {
    String startString;

    public void initialize(NameStart constraintAnnotation) {
        this.startString = constraintAnnotation.startChar();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext ctx) {
        if (s == null) {
            return false;
        }
        return s.startsWith(startString);
    }
}
