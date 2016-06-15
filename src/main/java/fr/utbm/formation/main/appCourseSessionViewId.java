/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.main;

import fr.utbm.formation.entity.Client;
import fr.utbm.formation.entity.CourseSession;
import fr.utbm.formation.repository.CourseSessionDAO;
import java.util.List;

/**
 *
 * @author Hervé MVENG
 */
public class appCourseSessionViewId {
    public static void main( String[] args){
        
        System.out.println("------ FORMATION -------");
        System.out.println("\n------ La session -------\n");
        
        CourseSessionDAO csDAO = new CourseSessionDAO();
        
        /*CourseSession cs = csDAO.getCourseSession(3);
        if(cs != null){
            System.out.println("Session du "+cs.getStartDate().toString()+ " au "+ cs.getEndDate().toString());
            System.out.println(" - "+ cs.getCourse().getTitle() + " à "+ cs.getLocation().getCity() +"\n");
        }
        */
       /* List<Client> cs = csDAO.getAllParticipantCourseSession(1);
        for(Client lst : cs){
            System.out.println(lst.getFisrtname());
        }
        */
    }
}
