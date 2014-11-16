/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.validator;

import com.model.Program;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Tomas
 */
@Component
public class ProgramValidator implements Validator {
    
    @Override
    public boolean supports(Class<?> clazz) {
        return Program.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Program ex = (Program) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "NotEmpty", "Date is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "exercise", "NotNull", "Please choose an exercise");
        if (ex.getRepetitions() < 1) {
            errors.rejectValue("repetitions", "NotNull", "Amount of repetitions has to be above 0");
        }
        
        if (ex.getSets() < 1) {
            errors.rejectValue("sets", "NotNull", "Amount of sets has to be above 0");
        }
        
        /*if (ex.getExercise() == null) {
            errors.rejectValue("exercise", "Null", "Please choose an exercise");
        }*/
    }
}
