/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.berthy.library.services;

import com.berthy.library.domain.Student;
import java.util.List;

/**
 *
 * @author WAGGIE
 */
public interface OldStudents {
    
    public List<Student> getStudNum(int i);
    public List<Student> findAll();
    
}
