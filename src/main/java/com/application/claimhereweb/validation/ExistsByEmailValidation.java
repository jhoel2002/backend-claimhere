package com.application.claimhereweb.validation;

import org.springframework.beans.factory.annotation.Autowired;

import com.application.claimhereweb.service.IUserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExistsByEmailValidation implements ConstraintValidator<ExistsByEmail, String> {

    @Autowired
    private IUserService service;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (service == null) {
            return true;
        }
        return !service.existsByUsername(username);
    }
    
}
