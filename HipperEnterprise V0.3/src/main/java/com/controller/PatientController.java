/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.*;
import com.reader.CSVReader;
import com.service.CommentService;
import com.service.ExerciseService;
import com.service.PatientService;
import com.service.ProgramService;
import com.validator.PatientValidator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import ma.MovingAverage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @Autowired
    private ProgramService programService;

    @Autowired
    private PatientValidator patientValidator;

    @InitBinder("patient")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(patientValidator);

    }

    @ModelAttribute("exercises")
    public List<Exercise> populateOfferedCourses() {
        return exerciseService.getExercises();
    }

    private static String titleNew = "New patient";
    private static String titleEdit = "Edit patient";
    private static String titlePatientExercise = "View Results";

    @RequestMapping(value = "/patientlist")
    public ModelAndView patientlist(HttpSession session) throws IOException {
        TherapistUser therapist = new TherapistUser();
        therapist = (TherapistUser) session.getAttribute("therapist");
        int TherapistID = (int) therapist.getId();
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
    public ModelAndView patientAdd(@ModelAttribute("patient") @Valid PatientUser patientUser,
            BindingResult result, HttpSession session) {

        if (result.hasErrors()) {
            ModelAndView view = new ModelAndView("/patient/addpatient");
            view.addObject("pageTitle", titleNew);
            view.addObject("patient", patientUser);
            return new ModelAndView("/patient/addpatient");
        }

        TherapistUser Therapist = null;
        Therapist = (TherapistUser) session.getAttribute("therapist");
        int TherapistID = (int) Therapist.getId();

        ModelAndView patientListView = new ModelAndView("/patient/listpatient");
        patientService.addPatient(patientUser, Therapist);

        List<PatientUser> patients = patientService.getPatientsFromTherapist(TherapistID);
        patientListView.addObject("patients", patients);
        String message = "Patient was successfully added.";
        patientListView.addObject("message", message);

        return patientListView;

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable long id) {

//        ModelAndView patientEditView = new ModelAndView("/patient/editpatient");
//        PatientUser patient = patientService.getPatient(id);
//        patientEditView.addObject("pageTitle", titleEdit);
//        patientEditView.addObject("patient", patient);
        ModelAndView patientEditView = new ModelAndView("/patient/editpatient");
        PatientUser patient = patientService.getPatient(id);
        patientEditView.addObject("pageTitle", titleEdit);
        patientEditView.addObject("patient", patient).addObject("patientId", patient.getId());

        List<Exercise> exercises = programService.getExercisesForPatienId(id);
        patientEditView.addObject("patientexercises", exercises);
        patientEditView.addObject("errored", false);
        return patientEditView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("patient") @Valid PatientUser patient, BindingResult result, HttpSession session) {

        if (result.hasErrors()) {

            ModelAndView view = new ModelAndView("/patient/editpatient");
            view.addObject("pageTitle", titleEdit);
            view.addObject("patient", patient);
            view.addObject("patientId", patient.getId());
            view.addObject("errored", true);

            List<Exercise> exercises = programService.getExercisesForPatienId(patient.getId());
            view.addObject("patientexercises", exercises);
            return view;
        }
        TherapistUser Therapist = new TherapistUser();
        Therapist = (TherapistUser) session.getAttribute("therapist");
        int TherapistID = (int) Therapist.getId();

        ModelAndView patientlistView = new ModelAndView("/patient/listpatient");
        patientService.updatePatient(patient);
        List<PatientUser> patients = patientService.getPatientsFromTherapist(TherapistID);
        patientlistView.addObject("patients", patients);

        String message = "Patient was successfully edited.";
        patientlistView.addObject("message", message);
        patientlistView.addObject("errored", false);

//        List<Exercise> patientexercises = patient.getExcersises();
//        patientlistView.addObject("patientexercises", patientexercises);
        return patientlistView;

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deletePatient(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("/patient/listpatient");
        patientService.deletePatient(id);
        List<PatientUser> patients = patientService.getPatients();
        modelAndView.addObject("patients", patients);
        String message = "Patient was successfully deleted.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value = "/addexercise/{id}", method = RequestMethod.GET)
    public ModelAndView addExerciseToPatientView(@PathVariable long id) {

        ModelAndView addExerciseView = new ModelAndView("/patient/addexercise");

        PatientUser currentPatient = patientService.getPatient(id);
        Program p = new Program();
        p.setPatient(currentPatient);

        List<Exercise> ex = exerciseService.getExercises();
        addExerciseView.addObject("patient", p.getPatient());
        addExerciseView.addObject("exercises", ex);
        addExerciseView.addObject("program", p);

        return addExerciseView;

    }

    @RequestMapping(value = "/addexercise", method = RequestMethod.POST)
    public ModelAndView patientView(@ModelAttribute("program") @Valid Program program, BindingResult result) {

        System.out.println("OK!!?!?");

        programService.addProgram(program);

        long patientId = program.getPatient().getId();
        PatientUser patient = patientService.getPatient(patientId);

        ModelAndView patientView = editPage(patientId);
        patientView.addObject("patient", patient);
        patientView.addObject("patientexercises", programService.getExercisesForPatienId(patientId));

        return patientView;

    }

//    @RequestMapping(value = "/addexercise/{id}", method = RequestMethod.POST)
//    public ModelAndView patientView(@PathVariable long id, @RequestParam(value = "exercise") Long exerciseId,
//            @RequestParam(value = "sets") String sets,
//            @RequestParam(value = "date") String date) {
//
//        //        ModelAndView patientView = new ModelAndView("/patient/editpatient");
//        if (sets.equals("") || date.equals("") || exerciseId == 0) {
//            return addExerciseToPatientView(id);
//        }
//
//        ModelAndView patientView = editPage(id);
//
//        PatientUser patient = patientService.getPatient(id);
//
//     //List<Program> programs = patient.getPrograms();
//        Program p = new Program();
//        p.setPatient(patient);
//        p.setExercise(exerciseService.getExercise(exerciseId));
//        p.setSets(Integer.parseInt(sets));
//        p.setDate(date);
//
//     //programs.add(p);
//        programService.addProgram(p);
//     //patientService.updatePatient(patient);
//
//        patientView.addObject("patient", patient);
//
//        List<Exercise> exercises = programService.getExercisesForPatienId(id);
//
//        patientView.addObject("patientexercises", exercises);
//
//        return patientView;
//
//    }
// view 
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

        ServletContext servletContext = request.getSession().getServletContext();

        InputStream is = null;
        String relaPath = "/resources/data/Knie strekken.csv";
        String absoPath = servletContext.getRealPath(relaPath);

        try {
            is = new FileInputStream(absoPath);
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

        int peaks = ma.countPeaks(awesomeArray);

        String array = "[";
        for (int i = 0; i < awesomeArray.length; i++) {
            array += awesomeArray[i];
            if (i != (awesomeArray.length - 1)) {
                array += ",";
            }
        }
        array += "]";

        patientViewGraph.addObject("sensordata", array);

        // title of the page
        patientViewGraph.addObject("pageTitle", titlePatientExercise);
        return patientViewGraph;
    }

    @RequestMapping(value = "/viewgraph2/{id}&{id2}", method = RequestMethod.POST)
    public ModelAndView viewGraphPageCommentAdd(HttpServletRequest request, @PathVariable Long id, @PathVariable int id2, @ModelAttribute Comment comment) {

        ModelAndView patientCommentAdded = new ModelAndView("/patient/viewgraph");
        PatientUser patient = patientService.getPatient(id2);
        Exercise exercise = exerciseService.getExercise(id);

        patientCommentAdded.addObject("exercise", exercise);
        patientCommentAdded.addObject("patient", patient).addObject("patientId", patient.getId());

        comment.setExersiseId(id);
        comment.setPatientId(id2);
        comment.setDate();
        commentService.addComment(comment);

        // comment section
        //             - new comment
        Comment newComment = new Comment();
        patientCommentAdded.addObject("comment", newComment);

        //             - list of comments
        List<Comment> allComments = commentService.getComments();
        ArrayList<Comment> comments = new ArrayList<Comment>();
        Comment[] allInArray = allComments.toArray(new Comment[allComments.size()]);

        for (Comment allInArray1 : allInArray) {
            if (allInArray1.getExersiseId() == id && allInArray1.getPatientId() == id2) {
                comments.add(allInArray1);
            }
        }

        patientCommentAdded.addObject("comments", comments);

        ServletContext servletContext = request.getSession().getServletContext();

        InputStream is = null;
        String relaPath = "/resources/data/Knie strekken.csv";
        String absoPath = servletContext.getRealPath(relaPath);

        try {
            is = new FileInputStream(absoPath);
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

        int peaks = ma.countPeaks(awesomeArray);

        String array = "[";
        for (int i = 0; i < awesomeArray.length; i++) {
            array += awesomeArray[i];
            if (i != (awesomeArray.length - 1)) {
                array += ",";
            }
        }
        array += "]";

        patientCommentAdded.addObject("sensordata", array);

        // title of the page
        patientCommentAdded.addObject("pageTitle", titlePatientExercise);

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
