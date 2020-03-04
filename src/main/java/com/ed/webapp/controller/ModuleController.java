package com.ed.webapp.controller;

import com.ed.webapp.model.Module;
import com.ed.webapp.model.Staff;
import com.ed.webapp.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/module")
public class ModuleController {
    @Autowired
    ModuleService moduleService;

    @GetMapping("/edit/{id}")
    public String editModulePage(Model model, @PathVariable String id) {
        model.addAttribute("current_module", moduleService.getModule(id));
        return "/module/edit";
    }

    @PostMapping("/edit/{id}")
    public RedirectView editModule(HttpSession session, Model model, @PathVariable String id, @ModelAttribute Module module) {
        module.setMdl_coordinator((Staff) session.getAttribute("staff_user"));
        Module updated = moduleService.updateModule(id, module);
        model.addAttribute("current_module", updated);
        return new RedirectView("/module/edit/" + id);
    }

    @GetMapping("/grades/{id}")
    @ResponseBody
    public Module moduleGrades(@PathVariable String id) {
        return moduleService.getModule(id);
    }
}
