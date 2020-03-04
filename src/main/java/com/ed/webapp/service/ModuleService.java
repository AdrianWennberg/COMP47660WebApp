package com.ed.webapp.service;

import com.ed.webapp.model.Module;
import com.ed.webapp.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {

    @Autowired
    ModuleRepository repository;

    public List<Module> getModulesForStaff(long stf_id) {
        return repository.findByStf_ID(stf_id);
    }

    public Module getModule(String id) {
        return repository.findById(Long.parseLong(id)).orElseThrow();
    }

    public Module updateModule(String id, Module new_module) {
        Module module = repository.findById(Long.parseLong(id)).orElse(new Module());
        module.setMdl_MAXSTD(new_module.getMdl_MAXSTD());
        module.setMdl_name(new_module.getMdl_name());
        module.setMdl_topic(new_module.getMdl_topic());
        module.setMdl_coordinator(new_module.getMdl_coordinator());

        return repository.save(module);
    }
}
