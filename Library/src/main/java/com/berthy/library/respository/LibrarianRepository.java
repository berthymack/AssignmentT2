/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.berthy.library.respository;

import com.berthy.library.domain.Librarian;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LibrarianRepository extends JpaRepository<Librarian, Long>{
    
}
