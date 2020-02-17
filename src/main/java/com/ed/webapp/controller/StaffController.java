package com.ed.webapp.controller;

import com.ed.webapp.model.Staff;
import com.ed.webapp.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class StaffController {

    @Autowired
    StaffRepository repository;

    @GetMapping("/staff")
    @ResponseBody
    public List<Staff> getStaff() {
        return repository.findAll();
    }

    @PostConstruct
    public void initialize() {
        List<Staff> staff = repository.findAll();
        if (staff.isEmpty()) {
            // TODO: Move default staff members to txt file
            Staff s = new Staff("tName", "pass", "temp", "name", 'f');
            System.out.println(s);
            try {
                repository.save(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
