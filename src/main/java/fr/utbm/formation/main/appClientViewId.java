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
 * @author Hervé MVENG
 */
public class appClientViewId {
    public static void main( String[] args){

           System.out.println("------ FORMATION -------");
           System.out.println("\n------ Update client -------\n");
           
           ClientDAO cliDAO = new ClientDAO();
           cliDAO.deleteClient(null);
           //cliDAO.addClient(cli);

       }  
}
