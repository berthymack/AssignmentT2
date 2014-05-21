/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.berthy.library.services.Imp;

import com.berthy.library.domain.Student;
import com.berthy.library.respository.StudentRepository;
import com.berthy.library.services.OldStudents;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WAGGIE
 */

@Service
public class OldStudentsImp implements OldStudents{
    
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getStudNum(int StudNum) {
      
    
        List<Student> student = new ArrayList<>();
        List<Student> newStudent = studentRepository.findAll();

        for (Student std : newStudent) {
            if (std.getStudNum() > StudNum) {
                student.add(std);
            }
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
     
    }

  
    
}
