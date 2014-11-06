/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Exercise;
import com.model.PatientUser;
import com.model.TherapistUser;
import com.service.ExerciseService;
import com.service.PatientService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ezra
 */
@Controller
@RequestMapping(value = "/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private ExerciseService exerciseService;

    @ModelAttribute("exercises")
    public List<Exercise> populateOfferedCourses() {
        return exerciseService.getExercises();
    }

    private static String titleNew = "New patient";
    private static String titleEdit = "Edit patient";

    @RequestMapping(value = "/patientlist")
    public ModelAndView patientlist( HttpSession session) throws IOException {
          TherapistUser Therapist = new TherapistUser();
        Therapist = (TherapistUser) session.getAttribute("therapist");
        int TherapistID = (int) Therapist.getId();
        ModelAndView patientListView = new ModelAndView("patient/listpatient");
        List<PatientUser> patients = patientService.getPatientsFromTherapist(TherapistID);
        patientListView.addObject("patients", patients);

        return patientListView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView patientAddPage() throws IOException {

        ModelAndView patientAddView = new ModelAndView("/patient/addpatient");
        patientAddView.addObject("pageTitle", titleNew);
        patientAddView.addObject("patient", new PatientUser());

        return patientAddView;

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView patientAdd(@ModelAttribute PatientUser patient, HttpSession session) {
        TherapistUser Therapist = new TherapistUser();
        Therapist = (TherapistUser) session.getAttribute("therapist");
        int TherapistID = (int) Therapist.getId();
        
        ModelAndView patientListView = new ModelAndView("/patient/listpatient");
        patientService.addPatient(patient);
        
        List<PatientUser> patients = patientService.getPatientsFromTherapist(TherapistID);
        patientListView.addObject("patients", patients);
        String message = "Patient was successfully added.";
        patientListView.addObject("message", message);

        return patientListView;

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable Long id) {

        ModelAndView patientEditView = new ModelAndView("/patient/editpatient");
        PatientUser patient = patientService.getPatient(id);
        patientEditView.addObject("pageTitle", titleEdit);
        patientEditView.addObject("patient", patient);

        return patientEditView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("patient") PatientUser patient) {

        ModelAndView patientlistView = new ModelAndView("/patient/listpatient");
        patientService.updatePatient(patient);
        List<PatientUser> patients = patientService.getPatients();
        patientlistView.addObject("patients", patients);

        String message = "Patient was successfully edited.";
        patientlistView.addObject("message", message);
        return patientlistView;

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deletePatient(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/patient/listpatient");
        patientService.deletePatient(id);
        List<PatientUser> patients = patientService.getPatients();
        modelAndView.addObject("patients", patients);
        String message = "Patient was successfully deleted.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value = "/addexercise/{id}", method = RequestMethod.GET)
    public ModelAndView addExerciseToPatientView(@PathVariable Long id) {

        ModelAndView addExerciseView = new ModelAndView("/patient/addexercisetopatient");

        PatientUser currentPatient = patientService.getPatient(id);
        List<Exercise> ex = exerciseService.getExercises();
        addExerciseView.addObject("patient", currentPatient);

        addExerciseView.addObject("exercises", ex);

        return addExerciseView;

    }

    @RequestMapping(value = "/addexercise/{id}", method = RequestMethod.POST)
    public ModelAndView patientView(@RequestParam(value="exercises1", required=false) Long exerciseId1, 
                                    @RequestParam(value="exercises2", required=false) Long exerciseId2,
                                    @RequestParam(value="exercises3", required=false) Long exerciseId3,
                                    @RequestParam(value="exercises4", required=false) Long exerciseId4,
                                    @PathVariable Long id, @ModelAttribute PatientUser patient) {

        ModelAndView patientView = new ModelAndView("patient/editpatient");
        patient = patientService.getPatient(id);
        
        List<Exercise> exercises = patient.getExcersises();

        exercises.add(exerciseService.getExercise(exerciseId1));
        exercises.add(exerciseService.getExercise(exerciseId2));
        exercises.add(exerciseService.getExercise(exerciseId3));
        exercises.add(exerciseService.getExercise(exerciseId4));

        patientService.updatePatient(patient);
        patientView.addObject("patient", patient);

        return patientView;

    }

}
