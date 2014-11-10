/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Exercise;
import com.model.PatientUser;
import com.model.TherapistUser;
import com.service.PatientService;
import com.service.TherapistService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
    @Autowired
    private TherapistService therapistService;
    
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public void addPatient(PatientUser patient) {
        getCurrentSession().save(patient);
    }
    
    public void addPatient(PatientUser patient, TherapistUser therapist) {
        
        TherapistUser T = therapistService.getTherapist(therapist.getId());
        if (!patient.getTherapists().contains(T)) {
            List<TherapistUser> TherapistList;
            TherapistList = patient.getTherapists();
            TherapistList.add(T);
            patient.setTherapists(TherapistList);
        } else {
        }
        getCurrentSession().save(patient);
    }
    
    public void updatePatient(PatientUser patient) {
        PatientUser patientToUpdate = getPatient(patient.getId());
        patientToUpdate.setFirstName(patient.getFirstName());
        patientToUpdate.setLastName(patient.getLastName());
        patientToUpdate.setEmail(patient.getEmail());
        patientToUpdate.setPassword(patient.getPassword());
        patientToUpdate.setAddress(patient.getAddress());
        patientToUpdate.setPostalCode(patient.getPostalCode());
        patientToUpdate.setCity(patient.getCity());
        patientToUpdate.setLength(patient.getLength());
        patientToUpdate.setWeight(patient.getWeight());
        patientToUpdate.setPrograms(patient.getPrograms());
//        patientToUpdate.setExcersises(patient.getExcersises());
        getCurrentSession().update(patientToUpdate);
    }
    
    public PatientUser getPatient(long id) {
        PatientUser patient = (PatientUser) getCurrentSession().get(PatientUser.class, id);
        return patient;
    }
    
    public void deletePatient(long id) {
        PatientUser patient = getPatient(id);
        if (patient != null) {
            getCurrentSession().delete(patient);
        }
    }
    
    public void addExercises(long id, List<Exercise> exercises) {
        
        PatientUser patient = getPatient(id);
        
    }
    
    @SuppressWarnings("unchecked")
    public List<PatientUser> getPatients() {
        
        return getCurrentSession().createQuery("from PatientUser").list();
    }
    
    public List<PatientUser> getPatientsFromTherapist(int TherapistID) {
        long TPID = Long.valueOf(TherapistID);
        
        Query query = getCurrentSession().createSQLQuery("SELECT * FROM User inner join Patient on User.id = Patient.id inner join Therapist_Patient on User.id = Therapist_Patient.Patient_ID and Therapist_Patient.Therapist_ID = ?").addEntity(PatientUser.class);
        List<PatientUser> Q = query.setInteger(0, TherapistID).list();
        
        return Q;
        
    }
    
    public void storeAllPatients(List<PatientUser> patients) {
        
        for (PatientUser patient : patients) {
            getCurrentSession().save(patient);
        }
        
    }
    
}
