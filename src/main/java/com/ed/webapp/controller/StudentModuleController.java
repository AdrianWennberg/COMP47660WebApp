package com.ed.webapp.controller;

import com.ed.webapp.model.Student;
import com.ed.webapp.model.StudentModule;
import com.ed.webapp.repository.StudentModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class StudentModuleController {

    @Autowired
    StudentModuleRepository studentModuleRepository;

   @GetMapping("/studentmodule")
   @ResponseBody
   public List<StudentModule> getStudent(){return studentModuleRepository.findAll();}


}
