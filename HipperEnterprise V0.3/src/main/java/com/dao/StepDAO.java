/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import org.springframework.stereotype.Repository;
import com.model.Steps;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Christiaan
 */
@Repository
public class StepDAO {
    
 @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
 public void addStep(Steps ex) {
        getCurrentSession().save(ex);
    }

    public void updateExercise(Steps ex) {
        Steps exToUpdate = getExercise(ex.getstepID());

        exToUpdate.setstepName(ex.getstepName());
        exToUpdate.setImg(ex.getImg());
        exToUpdate.setInformation(ex.getInformation());

        getCurrentSession().update(exToUpdate);

    }

    public Steps getExercise(long id) {
        Steps ex = (Steps) getCurrentSession().get(Steps.class, id);

        return ex;
    }

    public void deleteExecise(long id) {

        Steps ex = (Steps) getCurrentSession().get(Steps.class, id);
        if (ex != null) {
            getCurrentSession().delete(ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<Steps> getStepses() {
        return getCurrentSession().createQuery("FROM Exercise").list();
    }
    
    public void storeAllSteps(List<Steps> Steps) {
        
        for (Steps ex : Steps) {
             getCurrentSession().save(ex);
        }
        
    }

}

    

