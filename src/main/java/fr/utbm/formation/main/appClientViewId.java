/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.main;

import fr.utbm.formation.entity.Client;
import fr.utbm.formation.repository.ClientDAO;

/**
 *
 * @author HervÃ© MVENG
 */
public class appClientViewId {
    public static void main( String[] args){

           System.out.println("------ FORMATION -------");
           System.out.println("\n------ Get client -------\n");
           
           ClientDAO cliDAO = new ClientDAO();
           Client cli = cliDAO.getClient(1);
           if(cli != null){
              System.out.println(" - "+ cli.getFisrtname() + " "+ cli.getLastname() +" ");
              System.out.println(" --> du "+ cli.getCourseSession().getStartDate().toString()  +" au "+ cli.getCourseSession().getEndDate().toString() +
                                " à " + cli.getCourseSession().getLocation().getCity());
              System.out.println(" --:  "+ cli.getCourseSession().getCourse().getTitle()+"\n ");
           }

       }  
}
