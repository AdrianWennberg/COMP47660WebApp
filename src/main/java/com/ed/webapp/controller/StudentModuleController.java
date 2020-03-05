package com.ed.webapp.controller;

import com.ed.webapp.model.Student;
import com.ed.webapp.model.StudentModule;
import com.ed.webapp.repository.StudentModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class StudentModuleController {

    @Autowired
    StudentModuleRepository studentModuleRepository;

   // @GetMapping("student/module")
    //public List<StudentModule> getModule(Student student){
        //return studentModuleRepository.findByStudent(student);
    //}

}
