package com.ed.webapp.controller;

import com.ed.webapp.model.Module;
import com.ed.webapp.model.*;
import com.ed.webapp.service.ModuleService;
import com.ed.webapp.service.StudentModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/module")
public class ModuleController {
    @Autowired
    ModuleService moduleService;
    @Autowired
    StudentModuleService studentModuleService;

    @GetMapping("/module/{topic}")
    public ModelAndView moduleList(ModelMap model, @PathVariable String topic) {
        List<Module> moduleList = moduleService.getModuleByTopic(topic);
        if (moduleList.isEmpty()) {
            model.addAttribute("module error", "no modules finded");
            return new ModelAndView(new RedirectView("/student/profile"));
        }
        model.addAttribute("modules", moduleList);
        return new ModelAndView("/module/{topic}", model);
    }

    @GetMapping({"/edit/", "/edit"})
    public ModelAndView newModulePage(ModelMap model, HttpSession session) {
        Object user = session.getAttribute("staff_user");
        if (user == null) {
            return new ModelAndView(new RedirectView("/"));
        }
        Module module = new Module();
        module.setMdl_ID((long) 0);
        module.setMdl_coordinator((Staff) user);
        model.addAttribute("current_module", module);
        return new ModelAndView("/module/edit", model);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editModulePage(ModelMap model, @PathVariable String id) {
        model.addAttribute("current_module", moduleService.getModule(Long.parseLong(id)));
        return new ModelAndView("/module/edit", model);
    }

    @PostMapping("/edit/{id}")
    public RedirectView editModule(Model model, @PathVariable String id, @ModelAttribute Module module) {
        Module updated = moduleService.updateModule(Long.parseLong(id), module);
        model.addAttribute("current_module", updated);
        return new RedirectView("/module/edit/" + updated.getMdl_ID());
    }

    @GetMapping("/grades/{id}")
    public ModelAndView selectYearPage(ModelMap model, @PathVariable String id) {
        Module module = moduleService.getModule(Long.parseLong(id));
        model.addAttribute("current_module", module);
        model.addAttribute("year_list", module.getAllYears());
        model.addAttribute("selected_year", new Year());
        return new ModelAndView("/module/year", model);
    }

    @PostMapping("/grades/{id}")
    public RedirectView selectYear(@PathVariable String id, @ModelAttribute Year year) {
        return new RedirectView("/module/grades/" + id + "/" + year);
    }

    @GetMapping("/grades/{id}/{year}")
    public ModelAndView moduleGradesPage(ModelMap model, @PathVariable String id, @PathVariable String year) {
        model.addAttribute("current_module", moduleService.getModule(Long.parseLong(id)));
        model.addAttribute("current_year", Integer.parseInt(year));
        return new ModelAndView("/module/grades", model);
    }

    @PostMapping("/grades/{id}/{year}")
    public RedirectView moduleGrades(@PathVariable String id, @ModelAttribute Module module, @PathVariable String year) {
        studentModuleService.updateGrades(module.getStudents());
        return new RedirectView("/module/grades/" + id + "/" + year);
    }
}
