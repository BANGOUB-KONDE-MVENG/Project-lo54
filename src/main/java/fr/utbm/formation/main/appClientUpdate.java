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
public class appClientUpdate {
    public static void main( String[] args){

           System.out.println("------ FORMATION -------");
           System.out.println("\n------ Update client -------\n");
           
           //CourseSessionDAO csDAO = new CourseSessionDAO();
          // CourseSession cs = csDAO.getCourseSession(2);
           
           Client cli = new Client();
           cli.setFisrtname("Arnel Jaja");
           //cli.setLastname("ZEUFACK");
           cli.setAddress("28 rue Thiers, 90000 Belfort");
           //cli.setEmail("xxxx.yyyy@kbm.fr");
           cli.setPhone("06123456");
           //cli.setCourseSession(cs);
           
           ClientDAO cliDAO = new ClientDAO();
           cliDAO.updateClient(4, cli);
           //cliDAO.addClient(cli);

       }  
}
