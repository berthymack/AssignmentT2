/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.berthy.library.test.respository;

import com.berthy.library.app.conf.ConnectionConfig;
import com.berthy.library.domain.Books;
import com.berthy.library.respository.BooksRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BooksRepositoryTest {
    
    private static ApplicationContext ctx;
    private Long id;
    private BooksRepository repo;
    
    public BooksRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
        public void createBooks(){
        repo = ctx.getBean(BooksRepository.class);
       
        Books b = new Books.Builder("205166652-7897")
                .bookname("Nouvelle Vie")
                .author("Mr.B.Bertus")
                .build();
        
        repo.save(b);
        id = b.getId();
        
        Assert.assertNotNull(id);
        }
        
        
         @Test
        (dependsOnMethods = "createBooks")
         public void readBooks(){
         repo = ctx.getBean(BooksRepository.class);
         Books book = repo.findOne(id);
         Assert.assertEquals(book.getBookname(), "Nouvelle Vie");
         
     }
     
    @Test
     (dependsOnMethods = "readBooks")
     private void updateBooks(){
         repo = ctx.getBean(BooksRepository.class);
         Books book = repo.findOne(id);
         Books updatedBooks = new Books.Builder("205166652-7897")
                 .bookname("I dont Know my Name")
                 .author("Mr.B.Bertus")
                 .build();
        
         repo.save(updatedBooks);
         
         Books newBooks = repo.findOne(id);
         Assert.assertEquals(newBooks.getBookname(), "Nouvelle Vie");
         
     }
     
     @Test
     (dependsOnMethods = "updateBooks")
     private void deleteBooks(){
         repo = ctx.getBean(BooksRepository.class);
         Books book = repo.findOne(id);
         repo.delete(book);
         
         Books deletedBooks = repo.findOne(id);
         
         Assert.assertNull(deletedBooks);
         
         
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
