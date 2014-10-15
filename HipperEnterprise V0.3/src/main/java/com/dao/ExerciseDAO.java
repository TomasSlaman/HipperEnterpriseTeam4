/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Exercise;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author duytran
 */
@Repository
public class ExerciseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addExercise(Exercise ex) {
        getCurrentSession().save(ex);
    }

    public void updateExercise(Exercise ex) {
        Exercise exToUpdate = getExercise(ex.getExerciseId());

        exToUpdate.setExerciseName(ex.getExerciseName());
        exToUpdate.setDuration(ex.getDuration());
        exToUpdate.setExerciseType(ex.getExerciseType());

        getCurrentSession().update(exToUpdate);

    }

    public Exercise getExercise(long id) {
        Exercise ex = (Exercise) getCurrentSession().get(Exercise.class, id);

        return ex;
    }

    public void deleteExecise(long id) {

        Exercise ex = (Exercise) getCurrentSession().get(Exercise.class, id);
        if (ex != null) {
            getCurrentSession().delete(ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<Exercise> getExercises() {
        return getCurrentSession().createQuery("FROM Exercise").list();
    }
    
    public void storeAllExercises(List<Exercise> exercises) {
        
        for (Exercise ex : exercises) {
             getCurrentSession().save(ex);
        }
        
    }

}
