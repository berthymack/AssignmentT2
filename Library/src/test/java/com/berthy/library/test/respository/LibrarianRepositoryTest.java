/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.berthy.library.test.respository;

import com.berthy.library.app.conf.ConnectionConfig;
import com.berthy.library.domain.Contact;
import com.berthy.library.domain.Librarian;
import com.berthy.library.respository.LibrarianRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LibrarianRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private Contact c;

    private LibrarianRepository repo;
   
    
    public LibrarianRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createLibrarian() {
        repo = ctx.getBean(LibrarianRepository.class);
            c = new Contact();
            c.setAddress("35 George road 8000");
            c.setCell("0789513578");
            c.setLandline("0219586235");
         Librarian l = new Librarian.Builder(48)
                 .name("Marc")
                 .cont(c)
                 .build();
         repo.save(l);
         id = l.getId();
         Assert.assertNotNull(id);
    
    }
    
    @Test(dependsOnMethods = "createLibrarian")
     public void readLibrarian(){
         repo = ctx.getBean(LibrarianRepository.class);
         Librarian lib = repo.findOne(id);
         Assert.assertEquals(lib.getName(), "Marc");
         
     }
     
    @Test(dependsOnMethods = "readLibrarian")
     private void updateLibrarian(){
         repo = ctx.getBean(LibrarianRepository.class);
         Librarian lib = repo.findOne(id);
         Librarian updatedLibrarian = new Librarian.Builder(48)
                 .name("George")
                 .cont(c)
                 .build();
        
         repo.save(updatedLibrarian);
         
         Librarian newLibrarian = repo.findOne(id);
         Assert.assertEquals(newLibrarian.getName(), "Marc");
         
     }
     
     @Test(dependsOnMethods = "updateLibrarian")
     private void deleteLibrarian(){
         repo = ctx.getBean(LibrarianRepository.class);
         Librarian lib = repo.findOne(id);
         repo.delete(lib);
         
         Librarian deletedLibrarian = repo.findOne(id);
         
         Assert.assertNull(deletedLibrarian);
         
         
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
