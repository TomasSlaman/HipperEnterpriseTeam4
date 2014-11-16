/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.editor;

import com.model.PatientUser;
import com.service.PatientService;
import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author duytran
 */

@Component
public class PatientEditor extends PropertyEditorSupport {
    
    private PatientService patientService;
    
    public PatientEditor(){};

    public PatientEditor(PatientService patientService) {
        this.patientService = patientService;
    }
    
    @Override
    public void setAsText(String text) {
        System.out.println("PATIENT: " + text);
        PatientUser p = this.patientService.getPatient(Long.valueOf(text));

        this.setValue(p);
    }
    
    
}
