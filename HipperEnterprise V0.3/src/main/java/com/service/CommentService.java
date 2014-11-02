/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.CommentDAO;
import com.model.Comment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ezra
 */
@Service
@Transactional
public class CommentService {
    
    @Autowired
    private CommentDAO commentDAO;
    
    public void addComment(Comment ex) {
        commentDAO.addComment(ex);
    }
    
    public void updateComment(Comment ex) {
        commentDAO.updateComment(ex);
    }
    
    public Comment getComment(long id) {  
        return commentDAO.getComment(id);
    }
    
    public void deleteComment(long id) {      
        commentDAO.deleteComment(id);
    }
    
    public List<Comment> getComments() {     
        return commentDAO.getComments();
    }
    
    public void storeAllComments(List<Comment> comments) {    
        commentDAO.storeAllComments(comments);
    }
}
