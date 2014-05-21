/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.berthy.library.services.Imp;

import com.berthy.library.domain.SeminarRoom;
import com.berthy.library.respository.SeminarRoomRepository;
import com.berthy.library.services.SpecificRoom;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WAGGIE
 */

@Service
public class SpecificRoomImp implements SpecificRoom{

    @Autowired
    private SeminarRoomRepository seminarRoomRepository;
    
    @Override
    public List<SeminarRoom> getName(String Roomname) { 
        
        List<SeminarRoom> seminarRoom = new ArrayList<>();
        List<SeminarRoom> newSeminarRoom = seminarRoomRepository.findAll();

        for (SeminarRoom sr : newSeminarRoom) {
                sr.getRoomname();
                seminarRoom.add(sr);
            }
        return seminarRoom;
    }

    @Override
    public List<SeminarRoom> findAll() {
        return seminarRoomRepository.findAll();
        
    }
    
}
