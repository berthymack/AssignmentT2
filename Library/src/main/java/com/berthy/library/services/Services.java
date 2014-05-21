/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.berthy.library.services;

import java.util.List;

/**
 *
 * @author WAGGIE
 */
public interface Services <S, ID>{
    
    public S create(ID id);

    public S read(S entity);

    public S update(S entity);

    public void delete(S entity);

    public List<S> findAll();
    
}
