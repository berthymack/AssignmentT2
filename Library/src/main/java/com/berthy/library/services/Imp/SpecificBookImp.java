/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.berthy.library.services.Imp;

import com.berthy.library.domain.Books;
import com.berthy.library.respository.BooksRepository;
import com.berthy.library.services.SpecificBook;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WAGGIE
 */

@Service
public class SpecificBookImp implements SpecificBook {
    
    @Autowired
    private BooksRepository booksRepository;
    

    @Override
    public List<Books> getAuthor(String author) {
    
        List<Books> book = new ArrayList<>();
        List<Books> newBooks = booksRepository.findAll();

        for (Books bk : newBooks) {
            if (bk.getAuthor().equalsIgnoreCase(author)) {
                book.add(bk);
            }
        }
        return book;
    
    }
    
    
    @Override
    public List<Books> findAll() {
        return booksRepository.findAll();    
    
    }

}
