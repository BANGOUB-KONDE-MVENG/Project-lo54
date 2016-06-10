/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.service;

import fr.utbm.formation.entity.Course;
import java.util.List;

/**
 *
 * @author Cyntia KEMAMEN
 */
public interface CourseService {
    public List<Course> getAllCourse();
    public Course getCourse(int courseId);
    public void addCourse(Course c);
    public void deleteCourse(int courseId);
    public void updateCourse(int courseId, String title);
    public List<Course> findCourseByTitle(String keys);
}
