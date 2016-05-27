/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.repository;


import fr.utbm.formation.entity.Course;
import fr.utbm.formation.entity.CourseSession;
import fr.utbm.formation.entity.Location;
import fr.utbm.formation.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Cyntia KEMAMEN
 */
public class CourseSessionDAO {
    
    /*
    * return list of Course Session
    */
   public List<CourseSession> getAllCourseSession(){
      List<CourseSession> lstSession = new ArrayList<CourseSession>();     
      Session session = HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           List allSession = session.createQuery("from CourseSession").list();
           for(Iterator i = allSession.iterator(); i.hasNext();){
               CourseSession cSession = (CourseSession) i.next(); 
               
               Course c = new Course();
               c.setCode(cSession.getCourse().getCode());
               c.setTitle(cSession.getCourse().getTitle());
               
               Location l = new Location();
               l.setId(cSession.getLocation().getId());
               l.setCity(cSession.getLocation().getCity());
               
               CourseSession cs = new CourseSession();
               cs.setId(cSession.getId());
               cs.setStartDate(cSession.getStartDate());
               cs.setEndDate(cSession.getEndDate());
               cs.setCourse(c);
               cs.setLocation(l);
               
               lstSession.add(cs);
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
      return lstSession;
   }
   
   /*
   * return CourseSession by id
   */
   public CourseSession getCourseSession(int idSession){
       
       CourseSession cs = null;
       Session session = HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           Query query = session.createQuery("from CourseSession Where id = :idSession");
           query.setParameter("idSession", idSession);
           List c = query.list();
           cs = (CourseSession)c.get(0);
           
           Course course = new Course(cs.getCourse().getCode(), cs.getCourse().getTitle());
           Location location = new Location(cs.getLocation().getId(), cs.getLocation().getCity());
           
           cs.setCourse(course);
           cs.setLocation(location);
           
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
       return cs;
   }
   
   /*
   * add new CourseSession
   */
   public void addCourseSession(CourseSession cs){
       Session session = HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           session.persist(cs);
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
   * delete CourseSession
   */
   public void deleteCourseSession(int sessionId){
       Session session = HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           CourseSession cs = (CourseSession)session.get(CourseSession.class,sessionId);
           session.delete(cs);
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
   * update CourseSession
   */
   public void updateCourseSession(int courseId, Date deb, Date end){
       Session session = HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           CourseSession cs = (CourseSession)session.get(CourseSession.class,courseId);
           cs.setStartDate(deb);
           cs.setEndDate(end);
           session.update(cs);
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
    * return list of Course Session by date start and date end
    */
   public List<CourseSession> findCourseSessionBetweenStartAndEnd(Date start,Date end){
      List<CourseSession> lstSession = new ArrayList<CourseSession>();     
      Session session = HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           //List allSession = session.createQuery("from CourseSession").list();
           Query query = session.createQuery("from CourseSession Where startDate >= :dateStart and endDate <= :dateEnd");
           query.setParameter("dateStart",start);
           query.setParameter("dateEnd", end);
           List allSession = query.list();
           for(Iterator i = allSession.iterator(); i.hasNext();){
               CourseSession cSession = (CourseSession) i.next(); 
               
               Course c = new Course();
               c.setCode(cSession.getCourse().getCode());
               c.setTitle(cSession.getCourse().getTitle());
               
               Location l = new Location();
               l.setId(cSession.getLocation().getId());
               l.setCity(cSession.getLocation().getCity());
               
               CourseSession cs = new CourseSession();
               cs.setId(cSession.getId());
               cs.setStartDate(cSession.getStartDate());
               cs.setEndDate(cSession.getEndDate());
               cs.setCourse(c);
               cs.setLocation(l);
               
               lstSession.add(cs);
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
      return lstSession;
   }
   
   /*
    * return list of Course Session by date start
    */
   public List<CourseSession> findCourseSessionByDate(Date start){
      List<CourseSession> lstSession = new ArrayList<CourseSession>();     
      Session session = HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           //List allSession = session.createQuery("from CourseSession").list();
           Query query = session.createQuery("from CourseSession Where startDate >= :dateStart ");
           query.setParameter("dateStart",start);
           List allSession = query.list();
           for(Iterator i = allSession.iterator(); i.hasNext();){
               CourseSession cSession = (CourseSession) i.next(); 
               
               Course c = new Course();
               c.setCode(cSession.getCourse().getCode());
               c.setTitle(cSession.getCourse().getTitle());
               
               Location l = new Location();
               l.setId(cSession.getLocation().getId());
               l.setCity(cSession.getLocation().getCity());
               
               CourseSession cs = new CourseSession();
               cs.setId(cSession.getId());
               cs.setStartDate(cSession.getStartDate());
               cs.setEndDate(cSession.getEndDate());
               cs.setCourse(c);
               cs.setLocation(l);
               
               lstSession.add(cs);
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
      return lstSession;
   }

   /*
    * return list of Course Session by location
    */
   public List<CourseSession> findCourseSessionByLocation(int locationId){
      List<CourseSession> lstSession = new ArrayList<CourseSession>();     
      Session session = HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           Query query = session.createQuery("from CourseSession where location.id = :idLocation ");
           query.setParameter("idLocation",locationId);
           List allSession = query.list();
           for(Iterator i = allSession.iterator(); i.hasNext();){
               CourseSession cSession = (CourseSession) i.next(); 
               
               Course c = new Course();
               c.setCode(cSession.getCourse().getCode());
               c.setTitle(cSession.getCourse().getTitle());
               
               Location l = new Location();
               l.setId(cSession.getLocation().getId());
               l.setCity(cSession.getLocation().getCity());
               
               CourseSession cs = new CourseSession();
               cs.setId(cSession.getId());
               cs.setStartDate(cSession.getStartDate());
               cs.setEndDate(cSession.getEndDate());
               cs.setCourse(c);
               cs.setLocation(l);
               
               lstSession.add(cs);
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
      return lstSession;
   }
   
   
}
