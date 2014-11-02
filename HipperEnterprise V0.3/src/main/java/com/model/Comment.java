/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ezra
 */

@Entity
@Table(name = "Comment")
public class Comment implements Serializable{
    
    @Id
    @Column(name = "commentId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long CommentId;
    @Column(name = "exersiseId", nullable = false)  
    private int exersiseId;
    @Column(name = "patientId", nullable = false)  
    private int patientId;
    @Column(name = "comment", nullable = false)  
    private String comment;
    @Column(name = "date", nullable = false)  
    private String date;

    public Comment() {
    }

    public Comment(long CommentId, int exersiseId, int patientId, String comment, String date) {
        this.CommentId = CommentId;
        this.exersiseId = exersiseId;
        this.patientId = patientId;
        this.comment = comment;
        this.date = dateSetter();
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public long getCommentId() {
        return CommentId;
    }

    public void setCommentId(long CommentId) {
        this.CommentId = CommentId;
    }

    public int getExersiseId() {
        return exersiseId;
    }

    public void setExersiseId(int exersiseId) {
        this.exersiseId = exersiseId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate() {
        
        this.date = dateSetter();
        
    }
    
    private String dateSetter(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        Date date;
        String dateformat = "";
        try {
            date = sdf.parse("2014-10-30 00:00:00.0");
            sdf.applyPattern("dd-MMM-yyyy");
            dateformat = sdf.format(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return dateformat;
        
    }
    
    
    
    
}
