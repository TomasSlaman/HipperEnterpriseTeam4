/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.editor;


import com.model.Exercise;
import com.service.ExerciseService;
import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author duytran
 */

@Component
public class ExerciseEditor extends PropertyEditorSupport {
    
    @Autowired
    private ExerciseService teamService;

    // Converts a String team id to a Exercise (when submitting form)
    @Override
    public void setAsText(String text) {
        System.out.println(text);
       Exercise ex = this.teamService.getExercise(Integer.valueOf(text));

        this.setValue(ex);
    }

    
}
