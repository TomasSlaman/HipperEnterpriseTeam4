/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.editor;

import com.model.Exercise;
import com.service.ExerciseService;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Tomas
 */
@Component
public class ExerciseFormatter implements Formatter<Exercise> {

    @Autowired
    private ExerciseService exerciseService;

    @Override
    public String print(Exercise exercise, Locale arg1) {
        return exercise.getExerciseName();
    }

    @Override
    public Exercise parse(String exerciseId, Locale arg1) throws ParseException {
        long ex = Long.valueOf(exerciseId);
        return exerciseService.getExercise(ex);
           //Else you can just return a new object by setting some values
        //which you deem fit.
    }
}
