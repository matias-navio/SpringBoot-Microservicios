package com.microservice.student.services;

import com.microservice.student.entitites.Student;
import com.microservice.student.repositories.StudentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    private StudentRespository studentRespository;

    @Override
    public List<Student> findAll() {

        return (List<Student>) studentRespository.findAll();
    }

    @Override
    public Student findById(Long id) {

        return studentRespository.findById(id).orElseThrow();
    }

    @Override
    public Student save(Student student) {

        return studentRespository.save(student);
    }

    @Override
    public List<Student> findByCourseId(Long courseId) {

        return studentRespository.findAllByCourseId(courseId);
    }
}
