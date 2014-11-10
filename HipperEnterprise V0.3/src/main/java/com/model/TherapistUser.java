package com.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author Jeroen
 */
@Entity
@Table(name = "Therapist")
@PrimaryKeyJoinColumn(name = "id")
public class TherapistUser extends User {

    @Column(name = "occupation", nullable = true)
    private String occupation;
    @Column(name = "firm", nullable = true)
    private String firm;
    @Column(name = "role", nullable = true)
    private String role;

    @ManyToMany
    @JoinTable(
            name = "Therapist_Patient",
            joinColumns = {
                @JoinColumn(name = "Therapist_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "Patient_ID", referencedColumnName = "ID")})
    private List<PatientUser> Patients = new ArrayList();

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

    public List<PatientUser> getPatients() {
        return Patients;
    }

    public void setPatients(List<PatientUser> Patients) {
        this.Patients = Patients;
    }

}
