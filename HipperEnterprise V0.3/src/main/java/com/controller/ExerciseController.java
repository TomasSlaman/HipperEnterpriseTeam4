/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Exercise;
import com.model.Steps;
import com.service.ExerciseService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author duytran
 */
@Controller
@RequestMapping(value = "/exercise")
public class ExerciseController{
    @Autowired
    private ExerciseService service;
    @Autowired
    private HttpServletRequest request;

    private final static String TITLE_NEW = "New exercise";
    private final static String TITLE_EDIT = "Edit exercise";
    private final static String TITLE_ADDSTEP = "Add Step";
    private final static String TITLE_EDITSTEP = "Edit Step";

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
    public ModelAndView exerciseAdd(@ModelAttribute Exercise ex) throws IOException {

       

String act = request.getParameter("add");
if (act == null) {
    //no button has been selected
} else if (act.equals("Add Exercise")) {
    ModelAndView exerciseListView = new ModelAndView("/exercise/exercise_list");
        service.addExercise(ex);
        List<Exercise> exercises = service.getExercises();

        exerciseListView.addObject("exercises", exercises);
         return exerciseListView;
 
} else if (act.equals("Add a step")) {
     System.out.println("Step has been added");
     //ToDo: Add the exercise, as seen above.
     //Then the page needs to go to: addStep{ID} In which ID stands for the ID of the exercise which has just been created.
   
} else {
    //someone has altered the HTML and sent a different value!
}
        
        return null;

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
    public ModelAndView updateExercise(@ModelAttribute("exercise") Exercise ex) {

        ModelAndView exerciseListView = new ModelAndView("/exercise/exercise_list");
        service.updateExercise(ex);
        List<Exercise> exercises = service.getExercises();
        exerciseListView.addObject("exercises", exercises);

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

    @RequestMapping(value = "/addStep{id}", method = RequestMethod.GET)
    public ModelAndView addStep(@PathVariable Long id) {
        ModelAndView addStep = new ModelAndView("/exercise/add_step");

        Steps ST = new Steps(id);
        Exercise ex = service.getExercise(id);
        addStep.addObject("pageTitle", TITLE_ADDSTEP+" for "+ex.getExerciseName());
        addStep.addObject("exercise", ST);

        return addStep;

    }
    
    @RequestMapping(value = "/editStep{id}", method = RequestMethod.GET)
    public ModelAndView editStep(@PathVariable Long id) {
        ModelAndView editStep = new ModelAndView("/exercise/add_step");

        Steps ST = new Steps(id);
        Exercise ex = service.getExercise(id);
        editStep.addObject("pageTitle", TITLE_ADDSTEP+" for "+ex.getExerciseName());
        editStep.addObject("exercise", ST);

        return editStep;

    }

}
