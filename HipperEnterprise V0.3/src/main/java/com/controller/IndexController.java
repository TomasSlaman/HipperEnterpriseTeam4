package com.controller;


import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping(value = "/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }
    
    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpSession session){
        session.invalidate();
        return new ModelAndView("index");
    }
    
//    @RequestMapping(value = "/patient/patientlist")
//    public ModelAndView patientlist(){
//        return new ModelAndView("patient");
//    }
	
}
