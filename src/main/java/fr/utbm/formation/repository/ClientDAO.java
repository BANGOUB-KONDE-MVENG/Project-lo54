/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.repository;

import fr.utbm.formation.entity.Client;
import fr.utbm.formation.entity.Course;
import fr.utbm.formation.entity.CourseSession;
import fr.utbm.formation.entity.Location;
import fr.utbm.formation.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Cyntia KEMAMEN
 */
public class ClientDAO {
   
    /*
    * return list of client
    */
   public List<Client> getAllClient(){
      List<Client> lstClient = new ArrayList<Client>();     
      Session session = HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           List allClient = session.createQuery("from Client").list();
           for(Iterator i = allClient.iterator(); i.hasNext();){
               // get objet
               Client c = (Client) i.next(); 
               CourseSession cs = (CourseSession) c.getCourseSession();
               Location l = (Location) cs.getLocation();
               Course cur = (Course) cs.getCourse();
               
               //location
               Location loc = new Location(l.getId(), l.getCity());
               
               //course
               Course course = new Course(cur.getCode(),cur.getTitle());
               
               //courseSession
               CourseSession cSession = new CourseSession();
               cSession.setId(cs.getId());
               cSession.setEndDate(cs.getEndDate());
               cSession.setStartDate(cs.getStartDate());
               cSession.setLocation(loc);
               cSession.setCourse(course);
               
               // client
               Client cli = new Client();
               cli.setFisrtname(c.getFisrtname());
               cli.setLastname(c.getLastname());
               cli.setAddress(c.getAddress());
               cli.setEmail(c.getEmail());
               cli.setPhone(c.getPhone());
               cli.setCourseSession(cSession);
               
               lstClient.add(cli);
           }
           session.getTransaction().commit();
       }
       catch(HibernateException e){
           System.err.println("Initial SessionFactory creation failed.");
           if(session.getTransaction() != null){
               try{
                   session.getTransaction().rollback();
               }
               catch(HibernateException e2){
                   e2.printStackTrace();
               }
           }
       }
       finally{
           if(session != null){
               try{
                   session.close();
               }
               catch(HibernateException e3){
                   e3.printStackTrace();
               }
           }
       } 
      
      return lstClient;
   }
   
   /*
   * return client by id
   */
   public Client getClient(int id){
       
       return null;
   }
   
   /*
   * add new client
   */
   public void addClient(Client c){
       Session session = HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           session.persist(c);
           session.getTransaction().commit();
       }
       catch(HibernateException e){
           System.err.println("Initial SessionFactory creation failed.");
           if(session.getTransaction() != null){
               try{
                   session.getTransaction().rollback();
               }
               catch(HibernateException e2){
                   e2.printStackTrace();
               }
           }
       }
       finally{
           if(session != null){
               try{
                   session.close();
               }
               catch(HibernateException e3){
                   e3.printStackTrace();
               }
           }
       }
   }
   
   /*
   * delete client
   */
   public void deleteClient(Client c){
       
   }
   
   /* 
   * update client
   */
   
   public void updateClient(int clientId, Client c){
       Session session = HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           Client cli = (Client)session.get(Client.class,clientId);
           cli = updateClientByField(cli,c);
           session.update(cli);
           session.getTransaction().commit();
       }
       catch(HibernateException e){
           System.err.println("Initial SessionFactory creation failed.");
           if(session.getTransaction() != null){
               try{
                   session.getTransaction().rollback();
               }
               catch(HibernateException e2){
                   e2.printStackTrace();
               }
           }
       }
       finally{
           if(session != null){
               try{
                   session.close();
               }
               catch(HibernateException e3){
                   e3.printStackTrace();
               }
           }
       }
   }
   
   private Client updateClientByField(Client oldCli,Client newCli){
       if(newCli.getFisrtname() != null)
           oldCli.setFisrtname(newCli.getFisrtname());
       if(newCli.getLastname() != null)
           oldCli.setLastname(newCli.getLastname());
       if(newCli.getAddress() != null)
           oldCli.setAddress(newCli.getAddress());
       if(newCli.getEmail() != null)
           oldCli.setEmail(newCli.getEmail());
       if(newCli.getPhone() != null)
           oldCli.setPhone(newCli.getPhone());
       if(newCli.getCourseSession() != null)
           oldCli.setCourseSession(newCli.getCourseSession());
       
       return oldCli;
   }
    
}
