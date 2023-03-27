package com.boot.Curdproject.curdProject.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class imageNameValidator implements ConstraintValidator<imageNameValid,String> {

    @Override
    public void initialize(imageNameValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        //logic

        return false;
    }
}
