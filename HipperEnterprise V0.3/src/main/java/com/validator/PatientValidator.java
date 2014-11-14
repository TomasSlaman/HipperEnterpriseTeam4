/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.validator;

import com.model.PatientUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Tomas
 */
@Controller
public class PatientValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PatientUser.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {   
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "length", "NotEmpty", "Length is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "weight", "NotEmpty", "Weight is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty", "First name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty", "Last name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty", "Email is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty", "Password is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty", "Address name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postalCode", "NotEmpty", "Postal code type is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "NotEmpty", "City is required");
    }
}
