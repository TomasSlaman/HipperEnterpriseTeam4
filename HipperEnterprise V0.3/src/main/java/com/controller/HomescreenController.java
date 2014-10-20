/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.TherapistUser;
import com.service.TherapistService;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Tomas
 */
@Controller
@RequestMapping(value = "/homescreen")
public class HomescreenController {

    @Autowired
    private TherapistService therapistService;

    @RequestMapping(value = "/")
    public ModelAndView login(HttpSession session, @RequestParam(value = "email", required = false) String email, @RequestParam(value = "password", required = false) String password) throws IOException {
        if (session.getAttribute("therapist") != null) {
            return new ModelAndView("homescreen/home");
        }
        TherapistUser therapist = therapistService.getTherapist(email, password);
        ModelAndView mav = new ModelAndView("index");
        if (therapist != null) {
            session.setAttribute("therapist", therapist);
            mav = new ModelAndView("homescreen/home");
        }

        return mav;

    }

    @RequestMapping(value = "/home")
    public ModelAndView index(HttpSession session) {
        if (session.getAttribute("therapist") == null) {
            return new ModelAndView("index");
        }
        ModelAndView view = new ModelAndView("homescreen/home");
        return view;
    }
}
