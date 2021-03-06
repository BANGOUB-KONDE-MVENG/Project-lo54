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
public class appCourseSessionFindByLocation {
    public static void main( String[] args){
        
        
        int locationId = 7;
        
        
        CourseSessionDAO csDAO = new CourseSessionDAO();
        
        List<CourseSession> lstSession = new ArrayList<CourseSession>();
        lstSession = csDAO.findCourseSessionByLocation(locationId);
        
        System.out.println("------ FORMATION -------");
        System.out.println("\n------ Les sessions de la zone -------\n");
        for(CourseSession lst : lstSession){
            System.out.println("Session du "+lst.getStartDate().toString()+ " au "+ lst.getEndDate().toString());
            System.out.println(" - "+ lst.getCourse().getTitle() + " à "+ lst.getLocation().getCity() +"\n");
        }
        System.out.println("il y'a "+ lstSession.size()+" session de cours" );
    }
}
