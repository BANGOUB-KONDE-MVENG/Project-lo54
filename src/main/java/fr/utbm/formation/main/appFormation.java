/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.main;


import fr.utbm.formation.entity.CourseSession;
import fr.utbm.formation.repository.CourseSessionDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author HervÃ© MVENG
 */
public class appFormation {
    
    public static void main( String[] args){
        
        System.out.println("------ FORMATION -------");
        /*
        Location l = new Location();
        l.setCity("Londres");
        LocationDAO lDAO = new LocationDAO();
        lDAO.addLocation(l);
        
        Course c = new Course();
        c.setTitle("Project Manager");
        CourseDAO cDAO = new CourseDAO();
        cDAO.addCourse(c);
        */
        
        Date t = new Date();
        Date tt = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");
        try { 
          tt = ft.parse("23-05-2016");
        } catch (ParseException e) { 
            System.out.println("Unparseable using " + ft); 
        }
        
        CourseSession cs = new CourseSession();
        
        
        CourseSessionDAO csDAO = new CourseSessionDAO();
        //csDAO.addCourseSession(cs);
         
        //System.out.println(c.getTitle()+ " cours\n");
    }
}
