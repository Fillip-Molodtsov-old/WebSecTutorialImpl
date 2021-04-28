package com.mldtsv.amigossecurity.service;

import com.mldtsv.amigossecurity.domain.Student;
import com.mldtsv.amigossecurity.repository.StudentDAO;
import com.mldtsv.amigossecurity.web.StudentController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class StudentService {

    private StudentDAO studentDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public Optional<Student> findById(Integer id) {
        return studentDAO.findById(id);
    }

    public Collection<Student> getAll() {return studentDAO.getAll();}

    @Transactional
    public void createStudent(Student item) { studentDAO.create(item);}

    @Transactional
    public void updateStudent(Integer id, Student item) {studentDAO.update(id, item);}

    @Transactional
    public void deleteStudent(Integer id) {studentDAO.delete(id);}
}
