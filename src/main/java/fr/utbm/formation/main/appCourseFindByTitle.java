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
public class appCourseFindByTitle {
     public static void main( String[] args){
        
         String key = "Java";
        System.out.println("------ FORMATION -------");
        System.out.println("------ recherche de : "+ key+" -------");
        CourseDAO cDAO = new CourseDAO();
        List<Course> lstCourse = cDAO.findCourseByTitle(key);
        for(Course c : lstCourse){
            System.out.println(c.getCode()+" : "+ c.getTitle());
        }
        System.out.println("il ya " + lstCourse.size() + " cour(s) trouvé(s)");
        
     }
}
