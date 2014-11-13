/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controller;
import com.model.Exercise;
import com.service.ExerciseService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author duytran
 */

@Controller
@RequestMapping(value = "/exercise")
public class ExerciseController {
    
    @Autowired
    private ExerciseService service;
    
    private final static String TITLE_NEW = "New exercise";
    private final static String TITLE_EDIT = "Edit exercise";
    
    @RequestMapping(value = "/list")
    public ModelAndView exerciseListView() throws IOException {
        
        ModelAndView exerciseListView = new ModelAndView("/exercise/exercise_list");
        
        List<Exercise> exercises = service.getExercises();
        
        exerciseListView.addObject("exercises", exercises);
        
        return exerciseListView;
        
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addExerciseView() throws IOException {
        
        ModelAndView addExerciseView = new ModelAndView("/exercise/add_exercise");
        
        Exercise ex = new Exercise();
        
        addExerciseView.addObject("pageTitle", TITLE_NEW);
        addExerciseView.addObject("exercise", ex);
        
        return addExerciseView;
        
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView exerciseAdd(@ModelAttribute Exercise ex, HttpServletResponse resp) throws IOException {
        
        ModelAndView exerciseListView = new ModelAndView("/exercise/exercise_list");
        service.addExercise(ex);
        List<Exercise> exercises = service.getExercises();
        
        exerciseListView.addObject("exercises", exercises);
        resp.sendRedirect("../exercise/list");
        
        return exerciseListView;
        
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable Long id) {
        
        ModelAndView editExerciseView = new ModelAndView("/exercise/edit_exercise");
        Exercise ex = service.getExercise(id);
        editExerciseView.addObject("pageTitle", TITLE_EDIT);
        editExerciseView.addObject("exercise", ex);

        return editExerciseView;
        
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView updateExercise(@ModelAttribute("exercise") Exercise ex, HttpServletResponse resp) throws IOException {
        
        ModelAndView exerciseListView = new ModelAndView("/exercise/exercise_list");
        service.updateExercise(ex);
        List<Exercise> exercises = service.getExercises();
        exerciseListView.addObject("exercises", exercises);
        
        resp.sendRedirect("../exercise/list");
        
        return exerciseListView;
        
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteExercise(@PathVariable Long id) {
        
        ModelAndView exerciseListView = new ModelAndView("/exercise/exercise_list");
        service.deleteExercise(id);
        List<Exercise> exercises = service.getExercises();
        exerciseListView.addObject("exercises", exercises);
        return exerciseListView;
        
        
    }
    
}
