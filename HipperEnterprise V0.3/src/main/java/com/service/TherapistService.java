/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;


import com.dao.TherapistDao;
import com.model.TherapistUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Reserve
 */
@Service
@Transactional
public class TherapistService {

    @Autowired
    private TherapistDao therapistDAO;
    
    public void addTherapist(TherapistUser therapist) {
        therapistDAO.addTherapist(therapist);
    }

    public void updateTherapist(TherapistUser therapist) {
        therapistDAO.updateTherapist(therapist);
    }

    public TherapistUser getTherapist(long id) {
        return therapistDAO.getTherapist(id);
    }
    
    public TherapistUser getTherapist(String email, String password) {
        return therapistDAO.getTherapist(email, password);
    }

    public void deleteTherapist(long id) {
        therapistDAO.deleteTherapist(id);
    }

    public List<TherapistUser> getTherapists() {
        return therapistDAO.getTherapists();
    }

    public void storeAllTherapists(List<TherapistUser> therapists) {

        therapistDAO.storeAllTherapists(therapists);

    }

}
