package com.microservice.course.client;

import com.microservice.course.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "mvc-student", url = "http://localhost:8090/api/student")
public interface StudentClient {

    @GetMapping("/search/course/{courseId}")
    List<StudentDTO> findAllStudentsByCourse(@PathVariable Long courseId);
}
