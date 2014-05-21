/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.berthy.library.services;

import com.berthy.library.domain.Books;
import java.util.List;

/**
 *
 * @author WAGGIE
 */
public interface SpecificBook {
    
    public List<Books> getAuthor(String B);

    public List<Books> findAll();
    
}
