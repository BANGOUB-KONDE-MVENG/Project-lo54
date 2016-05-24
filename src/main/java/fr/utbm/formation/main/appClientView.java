/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.main;

import fr.utbm.formation.entity.Client;
import fr.utbm.formation.repository.ClientDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hervé MVENG
 */
public class appClientView {
    public static void main( String[] args){
        
        System.out.println("------ FORMATION -------");
        System.out.println("\n------ Les clients -------\n");
        
        ClientDAO cliDAO = new ClientDAO();
        
        List<Client> lstClient = new ArrayList<Client>();
        lstClient = cliDAO.getAllClient();
        for(Client lst : lstClient){
            System.out.println(" - "+ lst.getFisrtname() + " "+ lst.getLastname() +" ");
            System.out.println(" --> du "+ lst.getCourseSession().getStartDate().toString()  +" au "+ lst.getCourseSession().getEndDate().toString() +
                                " à " + lst.getCourseSession().getLocation().getCity());
            System.out.println(" --:  "+ lst.getCourseSession().getCourse().getTitle()+"\n ");
        }
    }
}
