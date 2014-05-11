/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.berthy.library.domain;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int studNum;
    private String name;
    
    
    @Embedded
    private Account account;

        
    @Embedded
    private Contact cont;

    
    
    private Student() {
        
        }
    
    private Student(Builder builder) {
        id = builder.id;
        studNum = builder.studNum;
        name = builder.name;
        account = builder.account;
        cont = builder.cont;
        }
    
    public static class Builder{
    private Long id;
    private int studNum;
    private String name;
    private Account account;
    private Contact cont;
        
    public Builder (int studNum){
            this.studNum = studNum;
        }   
    
        public Builder id(long id){
            this.id = id;
            return this;
        }   
        public Builder account(Account account) {
            this.account = account;
            return this;
        }
        
        
        
        public Builder cont(Contact cont) {
            this.cont = cont;
            return this;
        }
        
                
        public Builder name(String name){
            this.name = name;
            return this;
        } 
        
         public Builder (Student stud){
            id = stud.getId();
            studNum = stud.getStudNum();
            name = stud.getName();
            account = stud.getAccount();
            cont = stud.getCont();
            
        }  
        
              
        public Student build(){
            return new Student(this);
        }
    
        
    }

    

    public Long getId() {
        return id;
    }
    
    public int getStudNum() {
        return studNum;
    }

     public String getName() {
        return name;
    }
    
    public Account getAccount() {
        return account;
    }
    
    public Contact getCont() {
        return cont;
        }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.berthy.library.domain.Student[ id=" + id + " ]";
    }
    
}
