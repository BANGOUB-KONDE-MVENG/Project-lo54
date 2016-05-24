/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.main;

import fr.utbm.formation.repository.CourseSessionDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Hervé MVENG
 */
public class appCourseSessionUpdate {
    public static void main( String[] args){
        
        System.out.println("------ FORMATION -------");
        System.out.println("\n------ maj session -------\n");
        
        CourseSessionDAO csDAO = new CourseSessionDAO();
        Date t = new Date();
        Date tt = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");
        try { 
          tt = ft.parse("28-05-2016");
        } catch (ParseException e) { 
            System.out.println("Unparseable using " + ft); 
        }
        
        csDAO.updateCourseSession(1, t, tt);
        
    }
}
