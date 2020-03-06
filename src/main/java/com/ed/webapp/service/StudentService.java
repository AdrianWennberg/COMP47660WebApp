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
        Student student=new Student();
        student.setStd_ID(new_student.getStd_ID());
        student.setStd_name(student.getStd_name());
        student.setStd_username(new_student.getStd_username());
        student.setStd_address(new_student.getStd_address());
        student.setStd_email(new_student.getStd_email());
        student.setStd_password(new_student.getStd_password());
        student.setStd_sex(new_student.getStd_sex());
        return repository.save(student);

    }
}
