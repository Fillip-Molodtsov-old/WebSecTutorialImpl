package com.mldtsv.amigossecurity.web;

import com.mldtsv.amigossecurity.domain.Student;
import com.mldtsv.amigossecurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/student")
@PreAuthorize("hasAnyRole('ROLE_STUDENT', 'ROLE_ADMIN')")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{studentId}")
    public Student getById(@PathVariable("studentId") Integer studentId) {
        return studentService.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("No students with such id: " + studentId));
    }

    @GetMapping
    public Collection<Student> getAll() {
        return studentService.getAll();
    }

}
