package com.microservice.student.services;

import com.microservice.student.entitites.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();

    Student findById(Long id);

    Student save(Student student);

    List<Student> findByCourseId(Long courseId);
}
