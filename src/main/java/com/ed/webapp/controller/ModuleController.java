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

    @GetMapping({"/edit/", "/edit"})
    public ModelAndView newModulePage(@AuthenticationPrincipal UserDetails user, ModelMap model) {
        Module module = new Module();
        module.setMdl_ID((long) 0);
        module.setMdl_coordinator(staffService.getUser(user));
        model.addAttribute("current_module", module);
        logger.info(user.getUsername() + " is creating a new module.");
        return new ModelAndView("/module/edit", model);
    }

    @GetMapping({"/info/{id}"})
    public ModelAndView infoPage(@AuthenticationPrincipal UserDetails user, ModelMap model, @PathVariable String id) {
        if (user != null) {
            if (studentService.isStudent(user)) {
                model.addAttribute("student_user", studentService.getUser(user));
            }
            else if (staffService.isStaff(user)) {
                model.addAttribute("staff_user", staffService.getUser(user));
            }
        }

        model.addAttribute("current_module", moduleService.getModule(Long.parseLong(id)));
        return new ModelAndView("/module/info", model);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editModulePage(@AuthenticationPrincipal UserDetails user, ModelMap model, @PathVariable String id) {
        if (moduleService.verifyModuleOwner(user, id)) {
            return new ModelAndView(new RedirectView("/staff/profile"));
        }
        model.addAttribute("current_module", moduleService.getModule(Long.parseLong(id)));
        return new ModelAndView("/module/edit", model);
    }

    @PostMapping("/edit/{id}")
    public RedirectView editModule(@AuthenticationPrincipal UserDetails user, @ModelAttribute Module updatedModule, Model model, @PathVariable String id) {
        Staff staff = staffService.getUser(user);
        Module module = moduleService.getModule(Long.parseLong(id));

        if (module.isNotCoordinator(staff)) {
            logger.warn(staff.getStf_username() + " tried to edit the info of the module: " + module);
            return new RedirectView("/staff/profile");
        }

        Module updated = moduleService.updateModule(Long.parseLong(id), updatedModule);
        logger.info(staff.getStf_username() +
                            " edited the info of the module: " +
                            id +
                            " from " +
                            module +
                            " to " +
                            updatedModule);
        model.addAttribute("current_module", updated);
        return new RedirectView("/module/edit/" + updated.getMdl_ID());
    }

    @GetMapping("/grades/{id}")
    public ModelAndView selectYearPage(@AuthenticationPrincipal UserDetails user, ModelMap model, @PathVariable String id) {
        if (moduleService.verifyModuleOwner(user, id)) {
            return new ModelAndView(new RedirectView("/staff/profile"));
        }

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
    public ModelAndView moduleGradesPage(@AuthenticationPrincipal UserDetails user, ModelMap model, @PathVariable String id, @PathVariable String year) {
        if (moduleService.verifyModuleOwner(user, id)) {
            return new ModelAndView(new RedirectView("/staff/profile"));
        }
        model.addAttribute("current_module", moduleService.getModule(Long.parseLong(id)));
        model.addAttribute("current_year", Integer.parseInt(year));
        return new ModelAndView("/module/grades", model);
    }

    @PostMapping("/grades/{id}/{year}")
    public RedirectView moduleGrades(@AuthenticationPrincipal UserDetails user, @ModelAttribute Module updated, @PathVariable String id, @PathVariable String year) {
        Staff staff = staffService.getUser(user);
        Module module = moduleService.getModule(Long.parseLong(id));

        if (module.isNotCoordinator(staff)) {
            logger.warn(staff.getStf_username() + " tried to edit the grades of the module: " + module);
            return new RedirectView("/");
        }

        logger.info(staff.getStf_username() + " edited the grades of module: " + module);
        studentModuleService.updateGrades(updated.getStudents(), staff);
        return new RedirectView("/module/grades/" + id + "/" + year);
    }

    @PostMapping("/enroll")
    public RedirectView enroll(@AuthenticationPrincipal UserDetails user, @RequestParam String id) {
        Student student = studentService.getUser(user);

        Module module = moduleService.getModule(Long.parseLong(id));
        logger.info("User enrolled to module: " + student + ", " + module);
        studentModuleService.enrollStudent(student, module);
        return new RedirectView("/student/profile");
    }

    @PostMapping("/unenroll")
    public RedirectView unenroll(@AuthenticationPrincipal UserDetails user, @RequestParam String id) {
        Student student = studentService.getUser(user);

        Module module = moduleService.getModule(Long.parseLong(id));
        logger.info("User unenrolled from module: " + student + ", " + module);
        studentModuleService.unenrollStudent(student, module);
        return new RedirectView("/student/profile");
    }
}
