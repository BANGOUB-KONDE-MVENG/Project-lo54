/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.main;

import fr.utbm.formation.entity.Course;
import fr.utbm.formation.entity.Location;
import fr.utbm.formation.repository.CourseDAO;
import fr.utbm.formation.repository.LocationDAO;
import java.util.List;

/**
 *
 * @author Hervé MVENG
 */
public class appFormation {
    
    public static void main( String[] args){
        
        System.out.println("------ FORMATION -------");
        
        Location l = new Location();
        l.setCity("Besançon");
        LocationDAO lDAO = new LocationDAO();
        lDAO.updateLocation(2, "Belfort");
         
        //System.out.println(c.getTitle()+ " cours\n");
    }
}
