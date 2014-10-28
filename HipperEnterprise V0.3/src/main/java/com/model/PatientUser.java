package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
  * @author Jeroen
 */
@Entity
@Table(name = "Patient")
@PrimaryKeyJoinColumn(name="id")
public class PatientUser extends User{

@Column(name = "length", nullable = true) 
private String length;
@Column(name = "weight", nullable = true)
private String weight;

    public PatientUser(String length, String weight, long id, String firstname, String lastname, String email, String password, String addres, String postalCode, String city) {
        super(id, firstname, lastname, email, password, addres, postalCode, city);
        this.length = length;
        this.weight = weight;
    }
    
    public PatientUser(){
        
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

}
