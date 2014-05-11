/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.berthy.library.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Embeddable
public class Account implements Serializable {
    
    private int acc_num;
    private String date_booked;
    private String date_return;

    public void setAcc_num(int acc_num) {
        this.acc_num = acc_num;
    }

    public void setDate_booked(String date_booked) {
        this.date_booked = date_booked;
    }

    public void setDate_return(String date_return) {
        this.date_return = date_return;
    }

    public int getAcc_num() {
        return acc_num;
    }

    public String getDate_booked() {
        return date_booked;
    }

    public String getDate_return() {
        return date_return;
    }
    

   
    
}
