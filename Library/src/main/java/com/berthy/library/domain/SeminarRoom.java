/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.berthy.library.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author WAGGIE
 */
@Entity
public class SeminarRoom implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String isbn;
    private String roomname;
    
    
    private SeminarRoom ()
    {}
    
    private SeminarRoom ( Builder builder)
    {
        id = builder.id;
        isbn = builder.isbn;
        roomname = builder.roomname;
        //author = builder.author;
        
                   
    }
    
    
   
    
    public static class Builder
    {
            private Long id;
            private String isbn;
            private String roomname;
           // private String author;
           
            
            
            public Builder(String isbn)
            {
                this.isbn = isbn;
            }
            
            public Builder id(Long value)
            {
                this.id = value;
                return this;
            }
            
            public Builder roomname(String value)
            {
                this.roomname = value;
                return this;
            }
            
                      
           
            
           
            
            public Builder Sroom(SeminarRoom Sroom)
            {
                id = Sroom.getId();
                isbn = Sroom.getIsbn();
                roomname = Sroom.getRoomname();
                                
                
                return this;
            }
            
           
            public SeminarRoom build()
            {
                return new SeminarRoom(this);
            }

 
    }

    public Long getId() {
        return id;
    }

    public String getIsbn(){
        return isbn;
    }
    
    public String getRoomname(){
        return roomname;
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
        if (!(object instanceof SeminarRoom)) {
            return false;
        }
        SeminarRoom other = (SeminarRoom) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.berthy.library.domain.SeminharRoom[ id=" + id + " ]";
    }
    
}
