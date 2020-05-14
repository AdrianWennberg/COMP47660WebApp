package com.ed.webapp.controller;

import com.ed.webapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
    @Autowired
    ModuleService moduleService;
    @Autowired
    StaffService staffService;
    @Autowired
    StudentService studentService;

    @GetMapping({"", "/"})
    public ModelAndView schoolStatisticsPage(ModelMap model) {
        model.addAttribute("module_count", moduleService.getModuleCount());
        model.addAttribute("staff_count", staffService.getStaffCount());
        model.addAttribute("student_count", studentService.getStudentCount());

        return new ModelAndView("/statistics", model);
    }
}
