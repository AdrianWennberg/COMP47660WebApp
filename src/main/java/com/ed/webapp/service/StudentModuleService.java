package com.ed.webapp.service;

import com.ed.webapp.model.Module;
import com.ed.webapp.model.*;
import com.ed.webapp.repository.StudentModuleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentModuleService {
    @Autowired
    StudentModuleRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(StudentModuleService.class);

    public void updateGrades(List<StudentModule> students,Staff staff) {
        for (StudentModule student : students) {
            if (student.getId() != null) {
                StudentModule current = repository.findById(student.getId()).orElseThrow();
                current.setGrade(student.getGrade());
                repository.save(current);
                logger.info(staff.getStf_username() + " changed the grade of "+ student.getId());
            }
        }
    }

    public void deleteStudentModule(StudentModule studentModule) {
        repository.delete(studentModule);
    }

    public void enrollStudent(Student student, Module module) {
        StudentModule sm = new StudentModule(student, module, 2020, 2);
        sm.setId(new StudentModuleID(student.getStd_ID(), module.getMdl_ID()));
        repository.save(sm);
    }

    public void unenrollStudent(Student student, Module module) {
        StudentModuleID id = new StudentModuleID(student.getStd_ID(), module.getMdl_ID());
        StudentModule sm = repository.findById(id).orElseThrow();

        repository.delete(sm);
    }
}
