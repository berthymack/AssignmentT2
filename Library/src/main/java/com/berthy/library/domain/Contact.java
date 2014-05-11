/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.berthy.library.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;


@Embeddable
public class Contact implements Serializable{
    private String landline;
    private String address;
    private String cell;

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getLandline() {
        return landline;
    }

    public String getAddress() {
        return address;
    }

    public String getCell() {
        return cell;
    }

   
    
    
    
}
