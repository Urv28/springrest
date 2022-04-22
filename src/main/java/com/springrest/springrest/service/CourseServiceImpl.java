package com.springrest.springrest.service;

import com.springrest.springrest.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{

    List<Course> list;

    public CourseServiceImpl(){
        list = new ArrayList<>();
        list.add(new Course(145,"Java Core","Java Basics and Concepts"));
        list.add(new Course(146,"Spring Core","Spring Basics and Concepts"));
    }
    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourseById(long courseId) {
        return list.stream().filter(o -> o.getId()==courseId).findAny().orElse(null);
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {

        for(Course l : list)
        {
            if(l.getId()==course.getId())
            {
                l.setDescription(course.getDescription());
                l.setTitle(course.getTitle());
            }
        }
        return course;
    }

    @Override
    public void deleteCourse(long courseId) {
        list = list.stream().filter(e -> e.getId()!=courseId).collect(Collectors.toList());
    }
}
