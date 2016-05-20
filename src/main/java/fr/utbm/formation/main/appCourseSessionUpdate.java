/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.main;

import fr.utbm.formation.repository.CourseSessionDAO;

/**
 *
 * @author Hervé MVENG
 */
public class appCourseSessionUpdate {
    public static void main( String[] args){
        
        System.out.println("------ FORMATION -------");
        System.out.println("\n------ suppression session -------\n");
        
        CourseSessionDAO csDAO = new CourseSessionDAO();
        
        //csDAO.deleteCourseSession(3);
        
    }
}
