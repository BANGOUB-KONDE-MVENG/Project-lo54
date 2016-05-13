/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.repository;

import fr.utbm.formation.entity.Course;
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
public class CourseDAO {
 
    /*
    * return list of course
    */
   public List<Course> getAllCourse(){
      List<Course> allCourse;
      
      Session session = HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           allCourse = session.createQuery("from COURSE").list();
           /*for(Iterator i = allCourse.iterator(); i.hasNext();){
               lstCourse.add((Course)i.next());
           }
           */
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
      
      return allCourse;
   }
   
   /*
   * return course by id
   */
   public Course getCourse(int id){
       
       return null;
   }
   
   /*
   * add new course
   */
   public void addCourse(Course c){
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
   * delete Course
   */
   public void deleteCourse(int courseId){
      Session session = HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           Course c = (Course)session.get(Course.class,courseId);
           session.delete(c);
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
   * update course
   */
   public void updateCourse(int courseId, String title){
       Session session = HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           Course c = (Course)session.get(Course.class,courseId);
           c.setTitle(title);
           session.update(c);
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
