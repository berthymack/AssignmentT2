/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.berthy.library.test.respository;

import com.berthy.library.app.conf.ConnectionConfig;
import com.berthy.library.domain.Account;
import com.berthy.library.domain.Contact;
import com.berthy.library.domain.Student;
import com.berthy.library.respository.StudentRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class StudentRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private Contact c;
    private Account acc;

    private StudentRepository repo;
    
    public StudentRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createStudent() {
        repo = ctx.getBean(StudentRepository.class);
        acc = new Account();
        acc.setAcc_num(900693256);
        acc.setDate_booked("1 July 2014");
        acc.setDate_return("14 July 2014");
            c = new Contact();
            c.setAddress("35 George road 8000");
            c.setCell("0789513578");
            c.setLandline("0219586235");
         Student l = new Student.Builder(30088978)
                 .name("Simon")
                 .account(acc)
                 .cont(c)
                 .build();
         
         repo.save(l);
         id = l.getId();
         Assert.assertNotNull(id);
    
    }
     
     
     @Test(dependsOnMethods = "createStudent")
     public void readStudent(){
         repo = ctx.getBean(StudentRepository.class);
         Student stud = repo.findOne(id);
         Assert.assertEquals(stud.getName(), "Simon");
         
     }
     
    @Test(dependsOnMethods = "readStudent")
     private void updateStudent(){
         repo = ctx.getBean(StudentRepository.class);
         Student stud = repo.findOne(id);
         Student updatedStudent = new Student.Builder(30088978)
                 .name("Chistian")
                 .cont(c)
                 .account(acc)
                 .build();
        
         repo.save(updatedStudent);
         
         Student newStudent = repo.findOne(id);
         Assert.assertEquals(newStudent.getName(), "Simon");
         
     }
     
     @Test(dependsOnMethods = "updateStudent")
     private void deleteStudent(){
         repo = ctx.getBean(StudentRepository.class);
         Student stud = repo.findOne(id);
         repo.delete(stud);
         
         Student deletedStudent = repo.findOne(id);
         
         Assert.assertNull(deletedStudent);
         
         
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
