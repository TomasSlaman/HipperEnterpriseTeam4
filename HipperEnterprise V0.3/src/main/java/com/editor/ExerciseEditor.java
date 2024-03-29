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
    private ExerciseService exService;

    public ExerciseEditor() {
    }
    
    public ExerciseEditor(ExerciseService exService) {
        this.exService = exService;
    }
    
    // Converts a String team id to a Exercise (when submitting form)
    @Override
    public void setAsText(String text) {
        Exercise ex = this.exService.getExercise(Long.valueOf(text));
   
        this.setValue(ex);
    }
    
    /*@Override
    public String getAsText() {
        Exercise ex = (Exercise)this.getValue();
        return ex.getExerciseName();
    }*/

}
