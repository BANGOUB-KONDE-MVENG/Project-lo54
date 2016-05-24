/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.main;


import fr.utbm.formation.entity.CourseSession;
import fr.utbm.formation.repository.CourseSessionDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hervé MVENG
 */
public class appCourseSessionView {
    public static void main( String[] args){
        
        System.out.println("------ FORMATION -------");
        System.out.println("\n------ Les sessions -------\n");
        
        CourseSessionDAO csDAO = new CourseSessionDAO();
        
        List<CourseSession> lstSession = new ArrayList<CourseSession>();
        lstSession = csDAO.getAllCourseSession();
        for(CourseSession lst : lstSession){
            System.out.println("Session du "+lst.getStartDate().toString()+ " au "+ lst.getEndDate().toString());
            System.out.println(" - "+ lst.getCourse().getTitle() + " à "+ lst.getLocation().getCity() +"\n");
        }
    }
}
