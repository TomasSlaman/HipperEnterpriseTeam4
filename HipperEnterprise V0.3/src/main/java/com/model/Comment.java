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
    private long exersiseId;
    @Column(name = "patientId", nullable = false)  
    private long patientId;
    @Column(name = "comment", nullable = false)  
    private String comment;
    @Column(name = "date", nullable = false)  
    private String date;

    public Comment() {
    }

    public Comment(long exersiseId, long patientId, String comment, String date) {
        this.exersiseId = exersiseId;
        this.patientId = patientId;
        this.comment = comment;
        this.date = date;
    }
    
    

    public Comment(long CommentId, long exersiseId, long patientId, String comment, String date) {
        this.CommentId = CommentId;
        this.exersiseId = exersiseId;
        this.patientId = patientId;
        this.comment = comment;
        this.date = dateSetter();
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public long getCommentId() {
        return CommentId;
    }

    public void setCommentId(long CommentId) {
        this.CommentId = CommentId;
    }

    public long getExersiseId() {
        return exersiseId;
    }

    public void setExersiseId(long exersiseId) {
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date;
        String dateformat = "";
        try {
            date = new Date();
            dateformat = sdf.format(date);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return dateformat;
        
    }
    
    
    
    
}
