/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;


import com.model.TherapistUser;
import com.service.TherapistService;
import com.validator.TherapistValidator;
import java.io.IOException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/therapist")
public class TherapistController {

    @Autowired
    private TherapistService therapistService;
    
    @Autowired
    private TherapistValidator therapistValidator;
    
    @InitBinder("therapist")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(therapistValidator);
    }
    
    private static String titleNew = "New therapist";
    private static String titleEdit = "Edit therapist";
    
    @RequestMapping(value = "/therapistlist")
    public ModelAndView therapistList() throws IOException {
        ModelAndView therapistListView = new ModelAndView("therapist/listtherapist");
        List<TherapistUser> therapists = therapistService.getTherapists();
        therapistListView.addObject("therapists", therapists);

        return therapistListView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView therapistAddPage() throws IOException {

        ModelAndView therapistAddView = new ModelAndView("/therapist/addtherapist");
        therapistAddView.addObject("pageTitle", titleNew);
        therapistAddView.addObject("therapist", new TherapistUser());

        return therapistAddView;

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView therapistAdd(@ModelAttribute("therapist") @Valid TherapistUser therapist, BindingResult result) {

        if (result.hasErrors()) {
            ModelAndView view = new ModelAndView("/therapist/addtherapist");
            view.addObject("pageTitle", titleNew);
            view.addObject("therapist", therapist);
            return  view;
        }
        
        ModelAndView therapistListView = new ModelAndView("/therapist/listtherapist");
        therapistService.addTherapist(therapist);
        List<TherapistUser> therapists = therapistService.getTherapists();
        therapistListView.addObject("therapists", therapists);
        String message = "Therapist was successfully added.";
        therapistListView.addObject("message", message);

        return therapistListView;

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable Long id) {

        ModelAndView therapistEditView = new ModelAndView("/therapist/edittherapist");
        TherapistUser therapist = therapistService.getTherapist(id);
        therapistEditView.addObject("pageTitle", titleEdit);
        therapistEditView.addObject("therapist", therapist);
        therapistEditView.addObject("errored", false);
        return therapistEditView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("therapist") @Valid TherapistUser therapist, BindingResult result) {

        if (result.hasErrors()) {
            ModelAndView view = new ModelAndView("/therapist/edittherapist");
            view.addObject("pageTitle", titleEdit);
            view.addObject("therapist", therapist);
            view.addObject("errored", true);
            return view;
        }
        ModelAndView therapistlistView = new ModelAndView("/therapist/listtherapist");
        therapistService.updateTherapist(therapist);
        List<TherapistUser> therapists = therapistService.getTherapists();
        therapistlistView.addObject("therapists", therapists);

        String message = "therapist was successfully edited.";
        therapistlistView.addObject("message", message);
        return therapistlistView;

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteTherapist(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/therapist/listtherapist");
        therapistService.deleteTherapist(id);
        List<TherapistUser> therapists = therapistService.getTherapists();
        modelAndView.addObject("therapists", therapists);
        String message = "Therapist was successfully deleted.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

}
