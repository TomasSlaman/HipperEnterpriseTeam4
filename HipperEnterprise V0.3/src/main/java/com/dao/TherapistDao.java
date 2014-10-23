/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.TherapistUser;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Reserve
 */
@Repository
public class TherapistDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addTherapist(TherapistUser therapist) {
        getCurrentSession().save(therapist);
    }

    public void updateTherapist(TherapistUser therapist) {
        TherapistUser therapistToUpdate = getTherapist(therapist.getId());
        therapistToUpdate.setFirstName(therapist.getFirstName());
        therapistToUpdate.setLastName(therapist.getLastName());
        therapistToUpdate.setEmail(therapist.getEmail());
        therapistToUpdate.setPassword(therapist.getPassword());
        therapistToUpdate.setAddress(therapist.getAddress());
        therapistToUpdate.setPostalCode(therapist.getPostalCode());
        therapistToUpdate.setCity(therapist.getCity());
        therapistToUpdate.setFirm(therapist.getFirm());
        therapistToUpdate.setOccupation(therapist.getOccupation());
        therapistToUpdate.setRole(therapist.getRole());
        getCurrentSession().update(therapistToUpdate);
    }

    public TherapistUser getTherapist(long id) {
        TherapistUser therapist = (TherapistUser) getCurrentSession().get(TherapistUser.class, id);
        return therapist;
    }

    public TherapistUser getTherapist(String email, String password) {
        List<TherapistUser> therapists = new LinkedList();
        therapists = sessionFactory.getCurrentSession()
			.createQuery("from User where email=? AND password=?")
			.setParameter(0, email)
                        .setParameter(1, password)
			.list();
        
        TherapistUser therapist = null;
        if (therapists != null && therapists.size() > 0) {
            therapist = therapists.get(0);
        }
        return therapist;
    }

    public void deleteTherapist(long id) {
        TherapistUser therapist = getTherapist(id);
        if (therapist != null) {
            getCurrentSession().delete(therapist);
        }
    }

    @SuppressWarnings("unchecked")
    public List<TherapistUser> getTherapists() {
        return getCurrentSession().createQuery("from TherapistUser").list();
    }

    public void storeAllTherapists(List<TherapistUser> therapists) {

        for (TherapistUser therapist : therapists) {
            getCurrentSession().save(therapist);
        }

    }
}
