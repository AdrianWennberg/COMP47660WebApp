package com.ed.webapp.controller;

import com.ed.webapp.model.Staff;
import com.ed.webapp.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class StaffController {

    @Autowired
    StaffService service;

    @GetMapping("/staff/login")
    public ModelAndView loginPage(ModelMap model, HttpSession session) {
        if (session.getAttribute("staff_user") != null) {
            return new ModelAndView(new RedirectView("/"));
        }
        model.addAttribute("staff", new Staff());
        return new ModelAndView("staff/login", model);
    }

    @GetMapping("/staff/profile")
    public ModelAndView profilePage(ModelMap model, HttpSession session) {
        if (session.getAttribute("staff_user") == null) {
            return new ModelAndView(new RedirectView("/staff/login"));
        }
        return new ModelAndView("staff/profile", model);
    }

    @PostMapping("/staff/login")
    public ModelAndView login(ModelMap model, HttpSession session, @ModelAttribute Staff staff) {

        Optional<Staff> user = service.getStaffMember(staff);
        if (user.isEmpty()) {
            model.addAttribute("login_error", "Incorrect login!");
            return new ModelAndView("staff/login", model);
        }
        session.setAttribute("staff_user", user.get());
        return new ModelAndView(new RedirectView("/staff/profile"));
    }
}
