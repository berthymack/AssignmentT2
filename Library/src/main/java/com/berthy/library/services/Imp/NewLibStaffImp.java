/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.berthy.library.services.Imp;

import com.berthy.library.domain.Librarian;
import com.berthy.library.respository.LibrarianRepository;
import com.berthy.library.services.NewLibStaffs;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WAGGIE
 */

@Service
public class NewLibStaffImp implements NewLibStaffs{
    
    @Autowired
    private LibrarianRepository librarianRepository;

    @Override
    public List<Librarian> getLibAge(int age) {
    
        List<Librarian> librarian = new ArrayList<>();
        List<Librarian> newLibrarian = librarianRepository.findAll();

        for (Librarian lib : newLibrarian) {
            if (lib.getAge() < age) {
                librarian.add(lib);
            }
        }
        return librarian;

    }

    @Override
    public List<Librarian> findAll() {
        
        
        return librarianRepository.findAll();    
        
    }
    
}
