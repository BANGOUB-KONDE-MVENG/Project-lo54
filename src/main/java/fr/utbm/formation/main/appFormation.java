/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.main;


import fr.utbm.formation.entity.CourseSession;
import fr.utbm.formation.entity.Location;
import fr.utbm.formation.repository.CourseSessionDAO;
import fr.utbm.formation.repository.LocationDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        
        LocationDAO lDAO = new LocationDAO();
        List<Location> l = lDAO.getAllLocation();
        for(Location lst : l){
            System.out.println(" - "+ lst.getCity());
        }
    }
}
