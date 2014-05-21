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
public class Librarian implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    
    @Embedded
    private Contact cont;
    
    private Librarian(Builder builder) {
        id = builder.id;
        name = builder.name;
        age = builder.age;
        cont = builder.cont;
        }
    
    private Librarian() {
        
        }
    
    public static class Builder{
    private Long id;
    private String name;
    private int age;
    private Contact cont;

        

        public Builder(int age) {
            this.age = age;
        }
        
        public Builder id(long id){
            this.id = id;
            return this;
        }
        
        public Builder cont(Contact cont){
            this.cont = cont;
            return this;
        }
        
        public Builder name(String name){
            this.name = name;
            return this;
        }     
        
        public Builder builder(Librarian lib)
        {
            id = lib.getId();
            name = lib.getName();
            age = lib.getAge();
            cont = lib.getCont();
            return this;
        }
        
        public Librarian build(){
            return new Librarian(this);
        }
    
        
    }
    
    public Contact getCont() {
            return cont;
        }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
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
        if (!(object instanceof Librarian)) {
            return false;
        }
        Librarian other = (Librarian) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.berthy.library.domain.Librarian[ id=" + id + " ]";
    }
    
}
