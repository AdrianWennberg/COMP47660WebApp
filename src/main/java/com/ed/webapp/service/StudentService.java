package com.ed.webapp.service;

import com.ed.webapp.model.Student;
import com.ed.webapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;
    public List<Student>getAllStudents(){return repository.findAll();}
    public List<Student> getStudentByUsername(String username){return repository.findByUsername(username);}
    public Student createStudent(Student new_student){
        System.out.println(new_student);
        return repository.save(new_student);
    }
}
