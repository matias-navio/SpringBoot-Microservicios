package com.microservice.course.services;

import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;

import java.util.List;

public interface ICourseService {

    List<Course> findAll();

    Course findById(Long id);

    Course save(Course course);

    StudentByCourseResponse findStudentsByIdCourse(Long courseId);

}
