/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.repositoryTest;

import fr.utbm.formation.entity.CourseSession;
import fr.utbm.formation.repository.CourseSessionDAO;
import java.io.File;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Spy;

/**
 *
 * @author Cyntia KEMAMEN
 */
public class CourseSessionDAOTest {
    @Mock
    private static SessionFactory sessionFactory;
    @Mock
    private static Session session;
    @Mock 
    private CourseSession cs;
    @Spy
    List<CourseSession> cours;
    
    private static Configuration config;
    private CourseSessionDAO dao;
    
    public CourseSessionDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception{
        config = new AnnotationConfiguration();
        config.configure(new File("hibernate.cfg.xml"));
            sessionFactory = config.buildSessionFactory();
            session = sessionFactory.openSession();
      
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of getAllCourseSession method, of class CourseSessionDAO.
     */
    @Test
    public void testGetAllCourseSession() {
        System.out.println("getAllCourseSession");
        CourseSessionDAO instance = new CourseSessionDAO();
        List<CourseSession> expResult = null;
        List<CourseSession> result = instance.getAllCourseSession();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCourseSession method, of class CourseSessionDAO.
     */
    @Test
    public void testGetCourseSession() {
        System.out.println("getCourseSession");
        int idSession = 0;
        CourseSessionDAO instance = new CourseSessionDAO();
        CourseSession expResult = null;
        CourseSession result = instance.getCourseSession(idSession);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCourseSession method, of class CourseSessionDAO.
     */
    @Test
    public void testAddCourseSession() {
        System.out.println("addCourseSession");
        CourseSession cs = null;
        CourseSessionDAO instance = new CourseSessionDAO();
        instance.addCourseSession(cs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCourseSession method, of class CourseSessionDAO.
     */
    @Test
    public void testDeleteCourseSession() {
        System.out.println("deleteCourseSession");
        int sessionId = 0;
        CourseSessionDAO instance = new CourseSessionDAO();
        instance.deleteCourseSession(sessionId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCourseSession method, of class CourseSessionDAO.
     */
    @Test
    public void testUpdateCourseSession() {
        System.out.println("updateCourseSession");
        int courseId = 0;
        Date deb = null;
        Date end = null;
        CourseSessionDAO instance = new CourseSessionDAO();
        instance.updateCourseSession(courseId, deb, end);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCourseSessionBetweenStartAndEnd method, of class CourseSessionDAO.
     */
    @Test
    public void testFindCourseSessionBetweenStartAndEnd() {
        System.out.println("findCourseSessionBetweenStartAndEnd");
        Date start = null;
        Date end = null;
        CourseSessionDAO instance = new CourseSessionDAO();
        List<CourseSession> expResult = null;
        List<CourseSession> result = instance.findCourseSessionBetweenStartAndEnd(start, end);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCourseSessionByDate method, of class CourseSessionDAO.
     */
    @Test
    public void testFindCourseSessionByDate() {
        System.out.println("findCourseSessionByDate");
        Date start = new Date(2016-05-19);
        CourseSessionDAO instance = new CourseSessionDAO();
        List<CourseSession> expResult = null;
        List<CourseSession> result = instance.findCourseSessionByDate(start);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCourseSessionByLocation method, of class CourseSessionDAO.
     */
    @Test
    public void testFindCourseSessionByLocation() {
        System.out.println("findCourseSessionByLocation");
        int locationId = 7;
        CourseSessionDAO instance = new CourseSessionDAO();
        List<CourseSession> expResult = null;
        List<CourseSession> result = instance.findCourseSessionByLocation(locationId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
