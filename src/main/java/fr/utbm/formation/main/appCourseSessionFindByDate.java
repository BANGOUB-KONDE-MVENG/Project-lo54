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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Hervé MVENG
 */
public class appCourseSessionFindByDate {
    public static void main( String[] args){
        
        Date start = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        try { 
          start = ft.parse("2016-05-19");
        } catch (ParseException e) { 
            System.out.println("Unparseable using " + ft); 
        }
        
        
        CourseSessionDAO csDAO = new CourseSessionDAO();
        
        List<CourseSession> lstSession = new ArrayList<CourseSession>();
        lstSession = csDAO.findCourseSessionByDate(start);
        
        System.out.println("------ FORMATION -------");
        System.out.println("\n------ Les sessions dès le "+ start.toString() +" -------\n");
        for(CourseSession lst : lstSession){
            System.out.println("Session du "+lst.getStartDate().toString()+ " au "+ lst.getEndDate().toString());
            System.out.println(" - "+ lst.getCourse().getTitle() + " à "+ lst.getLocation().getCity() +"\n");
        }
        System.out.println("il y'a "+ lstSession.size()+" session de cours" );
    }
}
