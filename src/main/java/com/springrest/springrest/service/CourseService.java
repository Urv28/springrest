package com.springrest.springrest.service;

import com.springrest.springrest.entities.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();

    Course getCourseById(long courseId);

    Course addCourse(Course course);

    Course updateCourse(Course course);

    void deleteCourse(long courseId);
}
