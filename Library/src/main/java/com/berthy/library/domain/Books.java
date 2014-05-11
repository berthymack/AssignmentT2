/*
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


@Entity
public class Books implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String isbn;
    private String bookname;
    private String author;

   
    
     private Books(){
    
    }
    
    private Books ( Builder builder)
    {
        id = builder.id;
        isbn = builder.isbn;
        bookname = builder.bookname;
        author = builder.author;
        
                   
    }
    
    
   
    
    public static class Builder
    {
            private Long id;
            private String isbn;
            private String bookname;
            private String author;
           
            
            
            public Builder(String isbn)
            {
                this.isbn = isbn;
            }
            
            public Builder id(Long value)
            {
                this.id = value;
                return this;
            }
            
            public Builder bookname(String value)
            {
                this.bookname = value;
                return this;
            }
            
            public Builder author(String value)
            {
                this.author = value;
                return this;
            }
            
           
            
           
            
            public Builder books(Books books)
            {
                id = books.getId();
                isbn = books.getIsbn();
                bookname = books.getBookname();
                author = books.getAuthor();
                
                
                return this;
            }
            
           
            public Books build()
            {
                return new Books(this);
            }

 
    }
    
     public Long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getBookname() {
        return bookname;
    }

    public String getAuthor() {
        return author;
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
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.berthy.library.domain.Books[ id=" + id + " ]";
    }
    
}
