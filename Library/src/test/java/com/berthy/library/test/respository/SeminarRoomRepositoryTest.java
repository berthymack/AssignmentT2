/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.berthy.library.test.respository;

import com.berthy.library.app.conf.ConnectionConfig;
import com.berthy.library.domain.SeminarRoom;
import com.berthy.library.respository.SeminarRoomRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Berthy
 */
public class SeminarRoomRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
        
    private SeminarRoomRepository repo;
    
    public SeminarRoomRepositoryTest() {
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createSeminarRoom() {
        repo = ctx.getBean(SeminarRoomRepository.class);
        SeminarRoom s = new SeminarRoom.Builder("25869552-7857")
                .roomname("Seminar1")
                .build();
        
        repo.save(s);
        id = s.getId();
        
        Assert.assertNotNull(id);
    
    }
     
     @Test(dependsOnMethods = "createSeminarRoom")
     public void readSeminarRoom(){
         repo = ctx.getBean(SeminarRoomRepository.class);
         SeminarRoom s = repo.findOne(id);
         Assert.assertEquals(s.getRoomname(), "Seminar1");
         
     }
     
     @Test(dependsOnMethods = "readSeminarRoom", enabled = true)
     private void updateSeminarRoom(){
         repo = ctx.getBean(SeminarRoomRepository.class);
         SeminarRoom s = repo.findOne(id);
         SeminarRoom updatedSeminarRoom = new SeminarRoom.Builder("205869552-7857")
                 .roomname("Seminar2")
                 .build();
        
         repo.save(updatedSeminarRoom);
         
         SeminarRoom newSeminarRoom = repo.findOne(id);
         Assert.assertEquals(newSeminarRoom.getRoomname(), "Seminar1");
         
     }
     
     @Test(dependsOnMethods = "updateSeminarRoom", enabled = true)
     private void deleteSeminarRoom(){
         repo = ctx.getBean(SeminarRoomRepository.class);
         SeminarRoom s = repo.findOne(id);
         repo.delete(s);
         
         SeminarRoom deletedSeminarRoom = repo.findOne(id);
         
         Assert.assertNull(deletedSeminarRoom);
         
         
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
