package com.microservice.student.controller;

import com.microservice.student.entitites.Student;
import com.microservice.student.services.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/all")
    public ResponseEntity<?> findAllStudents() {

        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findStudentById(@PathVariable Long id) {

        return ResponseEntity.ok(studentService.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {

        return ResponseEntity.ok(studentService.save(student));
    }
}
