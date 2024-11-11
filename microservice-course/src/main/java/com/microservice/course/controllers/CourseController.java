package com.microservice.course.controllers;

import com.microservice.course.entities.Course;
import com.microservice.course.services.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseServiceImpl courseService;

    @GetMapping("/all")
    public ResponseEntity<?> findAllCourses() {

        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findCourseById(@PathVariable Long id) {

        return ResponseEntity.ok(courseService.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCourse(@RequestBody Course course) {

        return ResponseEntity.ok(courseService.save(course));
    }

    @GetMapping("/students/{courseId}")
    public ResponseEntity<?> findStudentsByIdCourse(@PathVariable Long courseId) {

        return ResponseEntity.ok(courseService.findStudentsByIdCourse(courseId));
    }
}
