/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.PatientUser;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ezra
 */

@Repository
public class PatientDao {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
    
    public void addPatient(PatientUser patient){
        getCurrentSession().save(patient);
    }
    
    public void updatePatient(PatientUser patient){
        PatientUser patientToUpdate = getPatient((int) patient.getId());
        patientToUpdate.setFirstName(patient.getFirstName());
        patientToUpdate.setLastName(patient.getLastName());
        patientToUpdate.setEmail(patient.getEmail());
        patientToUpdate.setPassword(patient.getPassword());
        patientToUpdate.setAddres(patient.getAddres());
        patientToUpdate.setPostalCode(patient.getPostalCode());
        patientToUpdate.setCity(patient.getCity());
        patientToUpdate.setLength(patient.getLength());
        patientToUpdate.setWeight(patient.getWeight());
        getCurrentSession().update(patientToUpdate);
    }
    
     public PatientUser getPatient(int id) {
        PatientUser patient = (PatientUser)getCurrentSession().get(PatientUser.class, id);
        return patient;
    }
     
     public void deletePatient(int id) {
        PatientUser patient = getPatient(id);
        if (patient != null) {
            getCurrentSession().delete(patient);
        }
    }
     
     @SuppressWarnings("unchecked")
    public List<PatientUser> getPatients() {
        return getCurrentSession().createQuery("from Patient").list();
    }

    public  void storeAllPatients(List<PatientUser> patients) {
             
        for (PatientUser patient : patients) {
            getCurrentSession().save(patient);
        }
       
    }
    
}
