/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Comment;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ezra
 */
@Repository
public class CommentDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void addComment(Comment ex) {
        getCurrentSession().save(ex);
    }

    public void updateComment(Comment ex) {
        Comment exToUpdate = getComment(ex.getCommentId());

        exToUpdate.setExersiseId(ex.getExersiseId());
        exToUpdate.setPatientId(ex.getPatientId());
        exToUpdate.setComment(ex.getComment());
        exToUpdate.setDate();

        getCurrentSession().update(exToUpdate);
    }

    public Comment getComment(long id) {
         Comment ex = (Comment) getCurrentSession().get(Comment.class, id);

        return ex;
    }

    public void deleteComment(long id) {
      Comment ex = (Comment) getCurrentSession().get(Comment.class, id);
        if (ex != null) {
            getCurrentSession().delete(ex);
        }
    }

    public List<Comment> getComments() {
         return getCurrentSession().createQuery("FROM Comment").list();
    }

    public void storeAllComments(List<Comment> comments) {
        for (Comment ex : comments) {
             getCurrentSession().save(ex);
        }
        
    }
    
}
