package com.ed.webapp.controller;

import com.ed.webapp.model.Module;
import com.ed.webapp.model.*;
import com.ed.webapp.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/module")
public class ModuleController {
    @Autowired
    ModuleService moduleService;
    @Autowired
    StudentModuleService studentModuleService;

    @Autowired
    public StaffService staffService;

    @Autowired
    public StudentService studentService;

    private static final Logger logger = LoggerFactory.getLogger(ModuleController.class);

    // Broken module search
//    @GetMapping("/module/{topic}")
//    public ModelAndView moduleList(ModelMap model, @PathVariable String topic) {
//        List<Module> moduleList = moduleService.getModuleByTopic(topic);
//        if (moduleList.isEmpty()) {
//            model.addAttribute("module error", "no modules finded");
//            return new ModelAndView(new RedirectView("/student/profile"));
//        }
//        model.addAttribute("modules", moduleList);
//        return new ModelAndView("/module/{topic}", model);
//    }

    @GetMapping({"/edit/", "/edit"})
    public ModelAndView newModulePage(@AuthenticationPrincipal UserDetails user, ModelMap model) {
        Module module = new Module();
        module.setMdl_ID((long) 0);
        module.setMdl_coordinator(staffService.getUser(user));
        model.addAttribute("current_module", module);
        logger.info(user.getUsername()+" is creating a new module ");
        return new ModelAndView("/module/edit", model);
    }

    @GetMapping({"/info/{id}"})
    public ModelAndView infoPage(@AuthenticationPrincipal UserDetails user, ModelMap model, @PathVariable String id) {
        Student studentUser = null;
        if (studentService.isStudent(user)) {
            studentUser = studentService.getUser(user);
        }
        Staff staffUser = null;
        if (staffService.isStaff(user)) {
            staffUser = staffService.getUser(user);
        }

        model.addAttribute("student_user", studentUser);
        model.addAttribute("staff_user", staffUser);
        model.addAttribute("current_module", moduleService.getModule(Long.parseLong(id)));
        return new ModelAndView("/module/info", model);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editModulePage(ModelMap model, @PathVariable String id) {
        model.addAttribute("current_module", moduleService.getModule(Long.parseLong(id)));
        return new ModelAndView("/module/edit", model);
    }

    @PostMapping("/edit/{id}")
    public RedirectView editModule(@AuthenticationPrincipal UserDetails user,Model model, @PathVariable String id, @ModelAttribute Module module) {
        Staff staff = staffService.getUser(user);
        if(moduleService.checkStaff(module,staff)){
            logger.info(staff.getStf_username() + " tried to edit the info of "+ module.getMdl_name());
            return new RedirectView("/staff/profile");
        }
        Module updated = moduleService.updateModule(Long.parseLong(id), module);
        logger.info(staff.getStf_username() + " edited the info of "+ module.getMdl_name());
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
    public RedirectView moduleGrades(@AuthenticationPrincipal UserDetails user,@PathVariable String id, @ModelAttribute Module module, @PathVariable String year) {
        Staff staff = staffService.getUser(user);
        if(moduleService.checkStaff(module, staff)){
            logger.info(staff.getStf_username() + " tried to edit the grades of "+ module.getMdl_name());
            return new RedirectView("/");
        }
        studentModuleService.updateGrades(module.getStudents(),staff);
        logger.info(staff.getStf_username() + " edited the grades of "+ module.getMdl_name());
        return new RedirectView("/module/grades/" + id + "/" + year);
    }

    @GetMapping("/enroll/{id}")
    public RedirectView enroll(@AuthenticationPrincipal UserDetails user, @PathVariable String id) {
        Student student = studentService.getUser(user);

        Module module = moduleService.getModule(Long.parseLong(id));
        studentModuleService.enrollStudent(student, module);
        return new RedirectView("/student/profile");
    }

    @GetMapping("/unenroll/{id}")
    public RedirectView unenroll(@AuthenticationPrincipal UserDetails user, @PathVariable String id) {
        Student student = studentService.getUser(user);

        Module module = moduleService.getModule(Long.parseLong(id));
        studentModuleService.unenrollStudent(student, module);
        return new RedirectView("/student/profile");
    }
}
