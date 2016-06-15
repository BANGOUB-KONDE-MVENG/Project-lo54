/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.repository;

import fr.utbm.formation.entity.Course;
import fr.utbm.formation.util.HibernateUtil;
import java.io.File;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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

/**
 *
 * @author Cyntia KEMAMEN
 */
public class CourseDAOTest {
    
    public CourseDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception{
        
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception{
       
    }
        
    @Test
    public void testAddCourse() {
        System.out.println("Test de la Methode addCourse");
        
        Course c = new Course();
        String titre="Analyse Numerique";
        c.setTitle(titre);
         
        CourseDAO instance = new CourseDAO();
        instance.addCourse(c);
        
        
        int id = c.getCode();
        
        assertNotNull("Objet dans la base de donnees", c);
        
        Course c2 = instance.getCourse(id);
        assertEquals("Test d'enregistrement titre",c2.getTitle(), c.getTitle());
        
    }

    
}
