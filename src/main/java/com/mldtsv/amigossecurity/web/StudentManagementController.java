package com.mldtsv.amigossecurity.web;

import com.mldtsv.amigossecurity.domain.Student;
import com.mldtsv.amigossecurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/management/student")
public class StudentManagementController {
    private StudentService studentService;

    @Autowired
    public StudentManagementController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void createStudent(@RequestBody Student st) {
        studentService.createStudent(st);
    }

    @PutMapping("{id}")
    public void updateStudent(@PathVariable("id") Integer id, @RequestBody Student st) {
        studentService.updateStudent(id, st);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
    }

}
