package com.ed.webapp.service;

import com.ed.webapp.model.Module;
import com.ed.webapp.model.StudentModule;
import com.ed.webapp.repository.StudentModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentModuleService {
    @Autowired
    StudentModuleRepository repository;
    //ModuleRepository moduleRepository;

    public List<StudentModule> getModulebyStudent(long std_id) {
        return repository.findByStd_id(std_id);
    }

    public String getModuleName(Module module) {
        return module.getMdl_name();
    }

    public void updateGrades(List<StudentModule> students) {
        for (StudentModule student : students) {
            if (student.getId() != null) {
                StudentModule current = repository.findById(student.getId()).orElseThrow();
                current.setGrade(student.getGrade());
                repository.save(current);
            }
        }
    }

    public void deleteStudentModule(StudentModule studentModule) {
        repository.delete(studentModule);
    }
}
