package com.application.claimhereweb.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Constraint(validatedBy = RequiredValidation.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsRequired {

    String message() default "es requerido!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
