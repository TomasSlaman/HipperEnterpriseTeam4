/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.validator;

import com.model.Exercise;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Tomas
 */
@Component
public class ExerciseValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Exercise.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Exercise ex = (Exercise) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "exerciseName", "NotEmpty", "Exercise name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "exerciseType", "NotEmpty", "Exercise type is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty", "Description is required");

        if (ex.getDuration() < 0.1) {
            errors.rejectValue("duration", "NotNull", "Duration has to be above 0");
        }
    }
}
