/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.editor.ExerciseEditor;
import com.model.Comment;
import com.model.Exercise;
import com.model.PatientUser;
import com.service.CommentService;
import com.service.ExerciseService;
import com.service.PatientService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
    
    @Autowired
    private CommentService commentService;

    @ModelAttribute("exercises")
    public List<Exercise> populateOfferedCourses() {
        return exerciseService.getExercises();
    }

    private static String titleNew = "New patient";
    private static String titleEdit = "Edit patient";
    private static String titlePatientExercise = "Results Patient";

    @RequestMapping(value = "/patientlist")
    public ModelAndView patientlist() throws IOException {
        ModelAndView patientListView = new ModelAndView("patient/listpatient");
        List<PatientUser> patients = patientService.getPatients();
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
    public ModelAndView patientAdd(@ModelAttribute PatientUser patient) {

        ModelAndView patientListView = new ModelAndView("/patient/listpatient");
        patientService.addPatient(patient);
        List<PatientUser> patients = patientService.getPatients();
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

        List<Exercise> patientexercises = patient.getExcersises();
        patientEditView.addObject("patientexercises", patientexercises);

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
    public ModelAndView patientView(HttpServletRequest request, @PathVariable Long id, @ModelAttribute PatientUser patient) {

        ModelAndView patientView = new ModelAndView("patient/editpatient");
        patient = patientService.getPatient(id);

        List<Exercise> exercises = patient.getExcersises();

        String[] ids = new String[4];

        for (int i = 0; i < ids.length; i++) {

            ids[i] = request.getParameter("exercises".concat(Integer.toString(i + 1)));
            Exercise ex = exerciseService.getExercise(Long.parseLong(ids[i]));
            exercises.add(ex);

        }

        patientService.updatePatient(patient);
        patientView.addObject("patient", patient);

        return patientView;

    }

    //View graph controller
    @RequestMapping(value = "/viewgraph/{id}", method = RequestMethod.GET)
    public ModelAndView viewGraphPage(@PathVariable Long id) {

        ModelAndView patientViewGraph = new ModelAndView("/patient/viewgraph");
        
        // exercise information
        Exercise exercise = exerciseService.getExercise(id);
        patientViewGraph.addObject("exercise", exercise);
        
        // comment section
        //             - new comment
        Comment comment = new Comment();
        comment.setExersiseId(id);
        comment.setPatientId(1);
        patientViewGraph.addObject("comment", new Comment());
        
        //             - list of comments
        List<Comment> comments = commentService.getComments();
        patientViewGraph.addObject("comments", comments);
        
        // title of the page
        patientViewGraph.addObject("pageTitle", titlePatientExercise);
        return patientViewGraph;
    }
    
     @RequestMapping(value = "/viewgraph/{id}", method = RequestMethod.POST)
    public ModelAndView viewGraphPageCommentAdd(@PathVariable Long id, @ModelAttribute Comment comment) {

        ModelAndView AddComment = new ModelAndView("/patient/viewgraph");
        
        
         comment.setDate();
         System.out.println(comment.getComment());
         System.out.println(comment.getDate());
         
        commentService.addComment(comment);
        
        List<Comment> comments = commentService.getComments();
        AddComment.addObject("comments", comments);
        
        Exercise exercise = exerciseService.getExercise(id);
        AddComment.addObject("exercise", exercise);

        return AddComment;

    }
    
    @RequestMapping(value = "/deletecomment/{id}", method = RequestMethod.GET)
    public ModelAndView deleteComment(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/patient/listpatient");
        commentService.deleteComment(id);
        List<PatientUser> patients = patientService.getPatients();
        modelAndView.addObject("patients", patients);
        String message = "Comment was successfully deleted.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }
}
