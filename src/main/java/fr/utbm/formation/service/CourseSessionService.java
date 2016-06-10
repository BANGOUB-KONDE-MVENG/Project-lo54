/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.service;

import fr.utbm.formation.entity.CourseSession;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Cyntia KEMAMEN
 */
public interface CourseSessionService {
    
    public List<CourseSession> getAllCourseSession();
    public CourseSession getCourseSession(int idSession);
    public void addCourseSession(CourseSession cs);
    public void deleteCourseSession(int sessionId);
    public void updateCourseSession(int courseId, Date deb, Date end);
    public List<CourseSession> findCourseSessionBetweenStartAndEnd(Date start,Date end);
    public List<CourseSession> findCourseSessionByDate(Date start);
    public List<CourseSession> findCourseSessionByLocation(int locationId);
}
