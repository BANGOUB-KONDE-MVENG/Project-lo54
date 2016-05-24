/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.main;

import fr.utbm.formation.entity.Client;
import fr.utbm.formation.entity.CourseSession;
import fr.utbm.formation.repository.ClientDAO;
import fr.utbm.formation.repository.CourseSessionDAO;

/**
 *
 * @author Hervé MVENG
 */
public class appClientAdd {
    public static void main( String[] args){

           System.out.println("------ FORMATION -------");
           System.out.println("\n------ add client -------\n");
           
           

           CourseSessionDAO csDAO = new CourseSessionDAO();
           CourseSession cs = csDAO.getCourseSession(4);
           
           Client cli = new Client();
           cli.setFisrtname("xxxxx");
           cli.setLastname("YYYYYYYY");
           cli.setAddress("7 avenue wilson, 90000 Belfort");
           cli.setEmail("xxxx.yyyy@kbm.fr");
           cli.setPhone("06123456");
           cli.setCourseSession(cs);
           
           ClientDAO cliDAO = new ClientDAO();
           cliDAO.addClient(cli);

       }   
}
