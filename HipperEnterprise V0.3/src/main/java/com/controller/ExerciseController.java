/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controller;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author duytran
 */

@Controller
@RequestMapping(value = "/exercise")
public class ExerciseController {
    
    @RequestMapping(value = "/list")
    public ModelAndView exerciseList() throws IOException {
        
        ModelAndView exerciseListView = new ModelAndView("exercise/exercise_list");
        
        return exerciseListView;
        
    }
    
}
