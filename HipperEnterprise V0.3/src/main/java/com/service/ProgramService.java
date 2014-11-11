/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.service;

import com.dao.ProgramDAO;
import com.model.Exercise;
import com.model.Program;
import com.model.TherapistUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author duytran
 */

@Service
@Transactional
public class ProgramService {
    
@Autowired
    private ProgramDAO programDAO;

    public void addProgram(Program program) {
        programDAO.addProgram(program);
    }

    public void updateProgram(Program program) {
        programDAO.updateProgram(program);
    }

    public Program getProgram(long id) {
        return programDAO.getProgram(id);
    }

    public void deleteProgram(long id) {
        programDAO.deleteProgram(id);
    }

    public List<Program> getPrograms() {
        return programDAO.getPrograms();

    }

    public List<Exercise>getExercisesForPatienId(int patientId){
        return programDAO.getExercisesForPatienId(patientId);

    }
    
    public void storeAllPrograms(List<Program> programs) {

        programDAO.storeAllPrograms(programs);

    }
}
