package com.ed.webapp.service;

import com.ed.webapp.model.Module;
import com.ed.webapp.model.Staff;
import com.ed.webapp.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {

    @Autowired
    ModuleRepository repository;

    public List<Module> getModuleByTopic(String topic){return repository.findByTopic(topic);}

    public Module getModule(long id) {
        return repository.findById(id).orElseThrow();
    }

    public Module updateModule(long id, Module new_module) {
        Module module = repository.findById(id).orElse(new Module());
        module.setMdl_MAXSTD(new_module.getMdl_MAXSTD());
        module.setMdl_name(new_module.getMdl_name());
        module.setMdl_topic(new_module.getMdl_topic());
        module.setMdl_coordinator(new_module.getMdl_coordinator());
        return repository.save(module);
    }

    public long getModuleCount() {
        return repository.count();
    }

    public boolean checkStaff(Module module, Staff staff) {
        return module.getMdl_coordinator().equals(staff);
    }
}
