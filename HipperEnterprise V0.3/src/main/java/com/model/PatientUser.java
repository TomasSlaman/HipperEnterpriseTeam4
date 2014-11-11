package com.model;

import com.service.TherapistService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author Jeroen
 */
@Entity
@Table(name = "Patient")
@PrimaryKeyJoinColumn(name = "id")
public class PatientUser extends User {

    @Column(name = "length", nullable = true)
    private String length;
    @Column(name = "weight", nullable = true)
    private String weight;

    @ManyToMany
    @JoinTable(
            name = "Therapist_Patient",
            joinColumns = {
                @JoinColumn(name = "Patient_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "Therapist_ID", referencedColumnName = "ID")})
    private List<TherapistUser> Therapists = new ArrayList();

    @OneToMany(fetch=FetchType.EAGER, mappedBy = "patient")
    private List<Program> programs = new ArrayList();

    public PatientUser(String length, String weight, long id, String firstname, String lastname, String email, String password, String addres, String postalCode, String city) {
        super(id, firstname, lastname, email, password, addres, postalCode, city);
        this.length = length;
        this.weight = weight;
    }

    public PatientUser() {

    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }

    public List<TherapistUser> getTherapists() {
        return Therapists;
    }

    public void setTherapists(List<TherapistUser> Therapists) {
        this.Therapists = Therapists;
    }

}
