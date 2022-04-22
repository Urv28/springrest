package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerOne {

    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home(){
        return "This is Home Page";
    }

    //getCourses
    @GetMapping("/courses")
    public List<Course> getCourses()
    {
        return this.courseService.getCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourseById(@PathVariable String courseId)
    {
        return this.courseService.getCourseById(Long.parseLong(courseId));

    }

    @PostMapping(path="/courses",consumes="application/json")
    public Course addCourse(@RequestBody Course course)
    {
        return this.courseService.addCourse(course);

    }


    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course)
    {
        return this.courseService.updateCourse(course);

    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> updateCourse(@PathVariable String courseId)
    {
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
