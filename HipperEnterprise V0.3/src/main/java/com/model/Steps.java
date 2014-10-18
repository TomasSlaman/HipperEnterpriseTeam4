/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Christiaan
 */

@Entity
@Table(name = "Steps")
public class Steps implements Serializable {

    @Id
    @Column(name = "stepID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long stepID;
    @Column(name = "stepName", nullable = false)
    private String stepName;
    @Column(name = "img", nullable = false)
    private String img;
    @Column(name = "Information", nullable = false)
    private String Information;
    @Column(name = "ExerciseID")
    private Long ExerciseID;

    public Steps() {

    }
    public Steps(long ExerciseID){
    this.ExerciseID = ExerciseID;
    }

    public Steps(String stepName, long stepID, String img) {
        this.stepName = stepName;
        this.stepID = stepID;
        this.img = img;
    }

    public long getstepID() {
        return stepID;
    }

    public void setstepID(long stepID) {
        this.stepID = stepID;
    }

    public String getstepName() {
        return stepName;
    }

    public void setstepName(String stepName) {
        if (stepName == null) {
            throw new NullPointerException("Step name field may not be empty");
        }
        this.stepName = stepName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getInformation() {
        return Information;
    }

    public void setInformation(String Information) {
        if (Information == null) {
            throw new NullPointerException("Information field may not be empty");
        }
        this.Information = Information;
    }

    public long getExerciseID() {
        return ExerciseID;
    }

    public void setExerciseID(long ExerciseID) {
        this.ExerciseID = ExerciseID;
    }

}
