/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.model.Exercise;
import com.model.Program;
import com.service.ExerciseService;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author duytran
 */
@Repository
public class ProgramDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired
    private ExerciseService exerciseService;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addProgram(Program p) {
        getCurrentSession().save(p);
    }

    public void updateProgram(Program p) {
        Program pToUpdate = getProgram(p.getId());

        pToUpdate.setPatient(p.getPatient());
        pToUpdate.setExercise(p.getExercise());
        pToUpdate.setSets(p.getSets());
        pToUpdate.setDate(p.getDate());
             
        getCurrentSession().update(pToUpdate);

    }

    public Program getProgram(long id) {
        Program p = (Program) getCurrentSession().get(Program.class, id);

        return p;
    }

    public void deleteProgram(long id) {

        Program p = (Program) getCurrentSession().get(Program.class, id);
        if (p != null) {
            getCurrentSession().delete(p);
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<Program> getPrograms() {
        return getCurrentSession().createQuery("FROM Program").list();
    }
    
    public List<Exercise> getExercisesForPatienId(long patientId) {
        
        Query query = getCurrentSession().createSQLQuery("SELECT * FROM Program INNER JOIN Exercise ON Exercise.exerciseId = exercise_exerciseId WHERE patient_id = ?").addEntity(Exercise.class);
        query.setLong(0, patientId);
        List<Exercise> ex = query.list();
        /*List<Integer> exerciseIds = query.setInteger(0, patientId).list();
        
        List<Exercise> exercises = new ArrayList();
    
        for (int i : exerciseIds) {
            
            exercises.add(exerciseService.getExercise(i));
            
        }*/
        
        return ex;
          
    }
    
    public void storeAllPrograms(List<Program> programs) {
        
        for (Program p : programs) {
             getCurrentSession().save(p);
        }
        
    }
    
}
