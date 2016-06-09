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
import org.hibernate.Query;
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
      List<Course> lstCourse = new ArrayList<Course>();     
      Session session = HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           List allCourse = session.createQuery("from Course").list();
           for(Iterator i = allCourse.iterator(); i.hasNext();){
               Course c = (Course) i.next(); 
               lstCourse.add(c);
           }
           session.getTransaction().commit();
       }
       catch(HibernateException e){
           System.err.println("Initial SessionFactory creation failed.");
           e.printStackTrace();
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
      
      return lstCourse;
   }
   
   /*
   * return course by id
   */
   public Course getCourse(int courseId){
       Course course = null;
       Session session = HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           Query query = session.createQuery("from Course Where code = :idCourse");
           query.setParameter("idCourse", courseId);
           List c = query.list();
           course = (Course)c.get(0);
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
       return course;
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
   
   /*
     return list of course by search
   */
   public List<Course> findCourseByTitle(String keys){
       List<Course> lstCourse = new ArrayList<Course>();     
      Session session = HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           Query query = session.createQuery("from Course Where title like :keyword");
           query.setParameter("keyword", "%"+keys+"%");
           List allCourse = query.list();
           for(Iterator i = allCourse.iterator(); i.hasNext();){
               Course c = (Course) i.next(); 
               lstCourse.add(c);
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
      
      return lstCourse;
   }
}
