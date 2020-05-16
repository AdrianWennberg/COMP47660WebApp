package com.ed.webapp.controller;

import com.ed.webapp.model.Staff;
import com.ed.webapp.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    StaffService staffService;

    @GetMapping("/login")
    public ModelAndView loginPage(@AuthenticationPrincipal UserDetails user) {
        if (user != null) {
            return new ModelAndView(new RedirectView("/"));
        }
        return new ModelAndView("/staff/login");
    }

    @GetMapping("/profile")
    public ModelAndView profilePage(@AuthenticationPrincipal UserDetails user, ModelMap model) {
        Staff staff = staffService.getUser(user);

        staff = staffService.updateStaffMember(staff);
        model.addAttribute("staff_user", staff);
        model.addAttribute("modules", staff.getModules());
        return new ModelAndView("/staff/profile", model);
    }
}
