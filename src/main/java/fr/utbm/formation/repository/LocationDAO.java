/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.repository;

import fr.utbm.formation.entity.Location;
import fr.utbm.formation.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Hervé MVENG
 */
public class LocationDAO {
    
    /*
    * return list of Location
    */
   public List<Location> getAllLocation(){
       
       return null;
   }
   
   /*
   * return Location by id
   */
   public Location getLocation(int id){
       
       return null;
   }
   
   /*
   * add new Location
   */
   public void addLocation(Location l){
       Session session = HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           session.persist(l);
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
   * delete Location
   */
   public void deleteLocation(Location l){
       
   }
   
   /* 
   * update Location
   */
   public void updateLocation(int cityId, String city){
       Session session = HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           Location l = (Location)session.get(Location.class,cityId);
           l.setCity(city);
           session.update(l);
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
}
