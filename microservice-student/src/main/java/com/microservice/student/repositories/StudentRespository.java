package com.microservice.student.repositories;

import com.microservice.student.entitites.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRespository extends CrudRepository<Student, Long>{

    List<Student> findAllByCourseId(Long courseId);
}
