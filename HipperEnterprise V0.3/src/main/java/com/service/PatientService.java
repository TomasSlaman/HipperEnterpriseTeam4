 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.PatientDao;
import com.model.PatientUser;

@Service
@Transactional
public class PatientService {

    @Autowired
    private PatientDao patientDAO;

    public void addPatient(PatientUser patient) {
        patientDAO.addPatient(patient);
    }

    public void updatePatient(PatientUser patient) {
        patientDAO.updatePatient(patient);
    }

    public PatientUser getPatient(long id) {
        return patientDAO.getPatient(id);
    }

    public void deletePatient(long id) {
        patientDAO.deletePatient(id);
    }

    public List<PatientUser> getPatients() {
        return patientDAO.getPatients();
    }

    public void storeAllPatients(List<PatientUser> patients) {
        patientDAO.storeAllPatients(patients);

    }
}
