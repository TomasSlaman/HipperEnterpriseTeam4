/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Tomas
 */
@Controller
@RequestMapping(value = "/homescreen")
public class HomescreenController {

    @RequestMapping(value = "/home")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("homescreen/home");
        return view;
    }
}
