package com.microservice.course.services;

import com.microservice.course.client.StudentClient;
import com.microservice.course.dto.StudentDTO;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentClient studentClient;

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {

        return (List<Course>) courseRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(Long id) {

        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Course save(Course course) {

        return courseRepository.save(course);
    }

    @Override
    @Transactional(readOnly = true)
    public StudentByCourseResponse findStudentsByIdCourse(Long courseId) {

        // consultar el curso
        Course course = courseRepository.findById(courseId).orElse(new Course());

        // obtener los estudiantes del curso
        List<StudentDTO> students = studentClient.findAllStudentsByCourse(courseId);

        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(students)
                .build();
    }
}
