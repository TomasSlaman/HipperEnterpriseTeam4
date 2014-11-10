/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Comment;
import com.model.Exercise;
import com.model.PatientUser;
import com.model.SensorData;
import com.model.TherapistUser;
import com.reader.CSVReader;
import com.service.CommentService;
import com.service.ExerciseService;
import com.service.PatientService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import ma.MovingAverage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
    private static String titlePatientExercise = "View Results";

    @RequestMapping(value = "/patientlist")
    public ModelAndView patientlist(HttpSession session) throws IOException {
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
        patientService.addPatient(patient, Therapist);

        List<PatientUser> patients = patientService.getPatientsFromTherapist(TherapistID);
        patientListView.addObject("patients", patients);
        String message = "Patient was successfully added.";
        patientListView.addObject("message", message);

        return patientListView;

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable Long id) {

//        ModelAndView patientEditView = new ModelAndView("/patient/editpatient");
//        PatientUser patient = patientService.getPatient(id);
//        patientEditView.addObject("pageTitle", titleEdit);
//        patientEditView.addObject("patient", patient);
        ModelAndView patientEditView = new ModelAndView("/patient/editpatient");
        PatientUser patient = patientService.getPatient(id);
        patientEditView.addObject("pageTitle", titleEdit);
        patientEditView.addObject("patient", patient).addObject("patientId", patient.getId());

        List<Exercise> patientexercises = patient.getExcersises();
        patientEditView.addObject("patientexercises", patientexercises);

        return patientEditView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("patient") PatientUser patient, HttpSession session) {

        TherapistUser Therapist = new TherapistUser();
        Therapist = (TherapistUser) session.getAttribute("therapist");
        int TherapistID = (int) Therapist.getId();

        ModelAndView patientlistView = new ModelAndView("/patient/listpatient");
        patientService.updatePatient(patient);
        List<PatientUser> patients = patientService.getPatientsFromTherapist(TherapistID);
        patientlistView.addObject("patients", patients);

        String message = "Patient was successfully edited.";
        patientlistView.addObject("message", message);

        List<Exercise> patientexercises = patient.getExcersises();
        patientlistView.addObject("patientexercises", patientexercises);

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
    public ModelAndView patientView(@RequestParam(value = "exercises1", required = false) Long exerciseId1,
            @RequestParam(value = "exercises2", required = false) Long exerciseId2,
            @RequestParam(value = "exercises3", required = false) Long exerciseId3,
            @RequestParam(value = "exercises4", required = false) Long exerciseId4,
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

    //View graph controller
    @RequestMapping(value = "/viewgraph1/{id}&{id2}", method = RequestMethod.GET)
    public ModelAndView viewGraphPage(HttpServletRequest request, @PathVariable Long id, @PathVariable Long id2) {

        ModelAndView patientViewGraph = new ModelAndView("/patient/viewgraph");

        Exercise exercise = exerciseService.getExercise(id);
        PatientUser patient = patientService.getPatient(id2);
        patientViewGraph.addObject("exercise", exercise);
        patientViewGraph.addObject("patient", patient).addObject("patientId", patient.getId());

        // comment section
        //             - new comment
        Comment comment = new Comment();
        patientViewGraph.addObject("comment", comment);

        //             - list of comments
        List<Comment> allComments = commentService.getComments();
        ArrayList<Comment> comments = new ArrayList<Comment>();
        Comment[] allInArray = allComments.toArray(new Comment[allComments.size()]);

        for (Comment allInArray1 : allInArray) {
            if (allInArray1.getExersiseId() == id && allInArray1.getPatientId() == id2) {
                comments.add(allInArray1);
            }
        }

        patientViewGraph.addObject("comments", comments);

        InputStream is = null;
        String realPath = request.getSession().getServletContext().getRealPath("data/Knie strekken.csv");

        try {
            is = new FileInputStream(realPath);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        Reader reader = new InputStreamReader(is);

        CSVReader csvr = new CSVReader(reader, SensorData.class);

        csvr.deserialize();

        List<SensorData> data = csvr.getItems();

        double[] xs = new double[data.size()];
        double[] ys = new double[data.size()];
        double[] zs = new double[data.size()];

        //Loop and print the items
        for (int i = 0; i < data.size(); i++) {
            xs[i] = data.get(i).getX();
            ys[i] = data.get(i).getY();
            zs[i] = data.get(i).getZ();
        }
        
        MovingAverage ma = new MovingAverage();
        
        int windowSize = 10;
        double[] awesomeArray = ma.movingAvg(xs, windowSize, new double[xs.length / windowSize + 1], 0, xs.length);

        for (int i = 0; i < awesomeArray.length; i++) {
            System.out.println(awesomeArray[i]);
        }

        System.out.println(ma.countPeaks(awesomeArray));

        // title of the page
        patientViewGraph.addObject("pageTitle", titlePatientExercise);
        return patientViewGraph;
    }

    @RequestMapping(value = "/viewgraph2/{id}&{id2}", method = RequestMethod.POST)
    public ModelAndView viewGraphPageCommentAdd(@PathVariable Long id, @PathVariable Long id2, @ModelAttribute Comment comment) {

        ModelAndView patientCommentAdded = new ModelAndView("/patient/editpatient");
        PatientUser patient = patientService.getPatient(id2);
        patientCommentAdded.addObject("pageTitle", titleEdit);
        patientCommentAdded.addObject("patient", patient).addObject("patientId", patient.getId());
        List<Exercise> patientexercises = patient.getExcersises();
        patientCommentAdded.addObject("patientexercises", patientexercises);

        comment.setExersiseId(id);
        comment.setPatientId(id2);
        comment.setDate();
        commentService.addComment(comment);

        return patientCommentAdded;

    }

    @RequestMapping(value = "/deletecomment/{id}", method = RequestMethod.GET)
    public ModelAndView deleteComment(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/patient/viewgraph");
        commentService.deleteComment(id);
        List<PatientUser> patients = patientService.getPatients();
        modelAndView.addObject("patients", patients);
        String message = "Comment was successfully deleted.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

}
