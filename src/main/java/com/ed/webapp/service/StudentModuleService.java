package com.ed.webapp.service;

import com.ed.webapp.model.Module;
import com.ed.webapp.model.Student;
import com.ed.webapp.model.StudentModule;
import com.ed.webapp.repository.ModuleRepository;
import com.ed.webapp.repository.StudentModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class StudentModuleService {
    @Autowired
    StudentModuleRepository repository;
    //ModuleRepository moduleRepository;

    public List<StudentModule> getModulebyStudent(long std_id) {
        return repository.findByStd_id(std_id);
    }
    public String getModuleName(Module module){
        return module.getMdl_name();
    }

}
