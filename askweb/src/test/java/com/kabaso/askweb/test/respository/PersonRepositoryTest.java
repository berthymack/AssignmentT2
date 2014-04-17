/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kabaso.askweb.test.respository;

import com.kabaso.askweb.app.conf.ConnectionConfig;
import com.kabaso.askweb.domain.Contact;
import com.kabaso.askweb.domain.Customer;
import com.kabaso.askweb.domain.Person;
import com.kabaso.askweb.respository.CustomerRepository;
import com.kabaso.askweb.respository.PersonRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author boniface
 */

public class PersonRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;

    private PersonRepository repo;
    
    public PersonRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createPerson() {
         repo = ctx.getBean(PersonRepository.class);
         Person p = new Person();
         p.setEmail("kabaso@cput.ac.za");
         p.setFirstname("B");
         p.setLastname("K");
         Contact c = new Contact();
         c.setAddress("p.O.Box 13");
         c.setCell("2424253");
         c.setLandline("12345");
         p.setContact(c);
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
         
     
     }
     
     @Test(dependsOnMethods = "createPerson")
     public void readPerson(){
         repo = ctx.getBean(PersonRepository.class);
         Person person = repo.findOne(id);
         Assert.assertEquals(person.getFirstname(), "B");
         
     }
     
    @Test(dependsOnMethods = "readPerson")
     private void updatePerson(){
         repo = ctx.getBean(PersonRepository.class);
         Person person = repo.findOne(id);
         person.setFirstname("Boniface");
         repo.save(person);
         
         Person updatePerson = repo.findOne(id);
         Assert.assertEquals(updatePerson.getFirstname(), "Boniface");
         
     }
     
     @Test(dependsOnMethods = "updatePerson")
     private void deletePerson(){
         repo = ctx.getBean(PersonRepository.class);
         Person person = repo.findOne(id);
         repo.delete(person);
         
         Person deletedPerson = repo.findOne(id);
         
         Assert.assertNull(deletedPerson);
         
         
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
