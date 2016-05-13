/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.main;

import fr.utbm.formation.entity.Course;
import fr.utbm.formation.repository.CourseDAO;
import java.util.List;

/**
 *
 * @author Hervé MVENG
 */
public class appFormation {
    
    public static void main( String[] args){
        
        System.out.println("------ FORMATION -------");
        
        Course c = new Course();
        //c.setCode(10);
        c.setTitle("LP40 klsbkbjk");
        CourseDAO cDAO = new CourseDAO();
        List<Course> lstCourse = cDAO.getAllCourse();
        /*List<Course> lstCourse = cDAO.getAllCourse();
         for(Course lst : lstCourse ){
             System.out.println(lst.getTitle()+ "\n");
         }
         */
        
    }
}
