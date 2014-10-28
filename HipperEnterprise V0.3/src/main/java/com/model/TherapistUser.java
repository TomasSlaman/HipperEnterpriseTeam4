package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
  * @author Jeroen
 */
@Entity
@Table(name = "Therapist")
@PrimaryKeyJoinColumn(name="id")
public class TherapistUser extends User {
    
    @Column(name = "occupation", nullable = true) 
    private String occupation;
    @Column(name = "firm", nullable = true) 
    private String firm;
    @Column(name = "role", nullable = true) 
    private String role;

    public TherapistUser() {
    }

    public TherapistUser(String occupation, String firm, long id, String firstname, String lastname, String email, String password, String addres, String postalCode, String city, String role) {
        super(id, firstname, lastname, email, password, addres, postalCode, city);
        this.occupation = occupation;
        this.firm = firm;
        this.role = role;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    

}
