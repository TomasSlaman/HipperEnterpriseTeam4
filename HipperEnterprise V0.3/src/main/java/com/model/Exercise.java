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
 * @author duytran
 */

@Entity
@Table(name = "Exercise")
public class Exercise implements Serializable {
    
    @Id
    @Column(name = "exerciseId")
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private long exerciseId;
    @Column(name = "exerciseName", nullable = false)
    private String exerciseName;
    @Column(name = "duration", nullable = false)
    private double duration;
    @Column(name = "exerciseType", nullable = false)
    private String exerciseType;
    
    public Exercise() {
        
    }
   
    public Exercise(String exerciseName, long exerciseId, double duration) {
       this.exerciseName = exerciseName;
       this.exerciseId = exerciseId;
       this.duration = duration;
    } 

    public long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
         if (exerciseName == null) {
            throw new NullPointerException("exercisename field may not be empty");
        }
        this.exerciseName = exerciseName;
    }
    
    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
         if (exerciseType == null) {
            throw new NullPointerException("Type field may not be empty");
        }
        this.exerciseType = exerciseType;
    }
  
}
