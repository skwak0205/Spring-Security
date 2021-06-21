package com.example.security.controller;

import com.example.security.dto.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Jane Doe"),
            new Student(2, "John Doe"),
            new Student(3, "Marry Doe")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") int studentId) {
        return STUDENTS.stream()
                .filter(student -> studentId == student.getStudentId())
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exists"));
    }
}
