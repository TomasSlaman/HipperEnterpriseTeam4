/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.service;

import com.dao.ExerciseDAO;
import com.model.Exercise;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author duytran
 */

@Service
@Transactional
public class ExerciseService {
    
    @Autowired
    private ExerciseDAO exerciseDAO;
    
    public void addExercise(Exercise ex) {
        exerciseDAO.addExercise(ex);
    }
    
    public void updateExercise(Exercise ex) {
        exerciseDAO.updateExercise(ex);
    }
    
    public Exercise getExercise(long id) {  
        return exerciseDAO.getExercise(id);
    }
    
    public void deleteExercise(long id) {      
        exerciseDAO.deleteExecise(id);
    }
    
    public List<Exercise> getExercises() {     
        return exerciseDAO.getExercises();
    }
    
    public void storeAllExercises(List<Exercise> exercises) {    
        exerciseDAO.storeAllExercises(exercises);
    }
}
