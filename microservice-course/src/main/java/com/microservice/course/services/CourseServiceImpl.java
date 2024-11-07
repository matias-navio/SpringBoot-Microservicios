package com.microservice.course.services;

import com.microservice.course.entities.Course;
import com.microservice.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {

        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {

        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public Course save(Course course) {

        return courseRepository.save(course);
    }
}
