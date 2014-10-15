/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.TherapistDao;
import com.model.TherapistUser;
import com.service.PatientService;
import com.service.TherapistService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Reserve
 */
@Controller
@RequestMapping(value = "/therapist")
public class TherapistController {

    @Autowired
    private TherapistService therapistService;

    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password) throws IOException {
        TherapistUser therapist = therapistService.getTherapist(email, password);
        ModelAndView mav = new ModelAndView("index");
        if (therapist != null) {
            mav = new ModelAndView("homescreen/home");
        }

        return mav;

    }
}
