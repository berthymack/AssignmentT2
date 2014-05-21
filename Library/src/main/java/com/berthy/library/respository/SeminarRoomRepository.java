/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.berthy.library.respository;

import com.berthy.library.domain.SeminarRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author WAGGIE
 */

@Repository
public interface SeminarRoomRepository extends JpaRepository<SeminarRoom,Long>{
    
}
