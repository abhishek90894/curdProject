package com.boot.Curdproject.curdProject.validate;

import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = imageNameValidator.class)
public @interface  imageNameValid {



}
