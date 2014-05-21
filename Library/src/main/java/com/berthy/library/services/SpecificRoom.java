/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.berthy.library.services;

import com.berthy.library.domain.SeminarRoom;
import java.util.List;

/**
 *
 * @author WAGGIE
 */
public interface SpecificRoom {
    
    public List<SeminarRoom> getName(String N);
    public List<SeminarRoom> findAll();
    
}
