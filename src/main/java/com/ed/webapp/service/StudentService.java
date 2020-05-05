package com.ed.webapp.service;

import com.ed.webapp.model.*;
import com.ed.webapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    @Autowired
    FeesService feesService;

    @Autowired
    StudentModuleService studentModuleService;

    public List<Student> getAllStudents() {return repository.findAll();}

    public List<Student> getStudentByUsername(String username) {return repository.findByUsername(username);}

    public Student createStudent(Student new_student) {
        System.out.println(new_student);
        return repository.save(new_student);
    }

    public long getStudentCount() {
        return repository.count();
    }

    public void deleteStudent(Student student) {
        System.out.println(student);
        student = repository.getOne(student.getStd_ID());
        System.out.println(student.getFees());
        System.out.println(student.getModules());
        for (Fees fees : student.getFees()) {
            feesService.deleteFees(fees);
        }

        for (StudentModule module : student.getModules()) {
            studentModuleService.deleteStudentModule(module);
        }

        repository.delete(student);
    }
}
