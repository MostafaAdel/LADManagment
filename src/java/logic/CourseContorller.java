/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.CourseDAOImpl;
import java.util.Iterator;

/**
 *
 * @author Mostafa_ITI
 */
public class CourseContorller {

    CourseDAOImpl courseDAOImpl = new CourseDAOImpl();

    public Iterator<Object[]> getAllCourses() {
        Iterator<Object[]> courses = courseDAOImpl.getCoursesNames();;
        return courses;
    }
}
