/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author duytran
 */

@Controller
public class IndexController {
    
    @RequestMapping(value = "/test")
    public ModelAndView loginScreen() throws IOException {
        
        ModelAndView mav = new ModelAndView("index");
        
        return mav;
        
    }
    
    @RequestMapping(value = "/")
    public ModelAndView index() throws IOException {
        
        
        System.out.println("!!?!?!?");
        ModelAndView mav = new ModelAndView("index");
        
        return mav;
    }
    
}
