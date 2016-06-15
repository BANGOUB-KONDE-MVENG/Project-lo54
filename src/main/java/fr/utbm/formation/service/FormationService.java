/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.service;

import fr.utbm.formation.entity.Client;
import fr.utbm.formation.entity.Course;
import fr.utbm.formation.repository.ClientDAO;
import fr.utbm.formation.repository.CourseDAO;
import fr.utbm.formation.repository.CourseSessionDAO;
import fr.utbm.formation.repository.LocationDAO;
import java.util.List;

/**
 *
 * @author Cyntia KEMAMEN
 */
public class FormationService {
    private ClientDAO clidao = null;
    private CourseDAO cdao = null;
    private CourseSessionDAO csdao = null;
    private LocationDAO ldao = null;
   
    /**
     *
     * @param clidao
     */
    public void setClientDAO(ClientDAO clidao){
        this.clidao = clidao;
    }
    public List<Client> getAllClient(){
        
       return  clidao.getAllClient();
    }
    
    
    
}
