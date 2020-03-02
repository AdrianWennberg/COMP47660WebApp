package com.ed.webapp.controller;

import com.ed.webapp.model.Staff;
import com.ed.webapp.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
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

    @GetMapping("/staff/login")
    public ModelAndView loginPage(ModelMap model, HttpSession session) {
        if (session.getAttribute("staff_user") != null) {
            return new ModelAndView(new RedirectView("/"));
        }
        model.addAttribute("staff", new Staff());
        return new ModelAndView("staff/login", model);
    }

    @PostMapping("/staff/login")
    public ModelAndView login(ModelMap model, HttpSession session, @ModelAttribute Staff staff) {
        List<Staff> found = repository.findByUsername(staff.getStf_username());
        if (found.size() == 1) {
            Staff user = found.get(0);
            if (user.checkPassword(staff.getStf_password())) {
                session.setAttribute("staff_user", user);
                if (session.getAttribute("staff_user") != null) {
                    return new ModelAndView(new RedirectView("/"));
                }
            }
        }
        else if (found.isEmpty()) {
            System.out.println("Error");
        }
        else {
            throw new RuntimeException("Multiple staff members found!");
        }
        model.addAttribute("login_error", "Incorrect login!");
        return new ModelAndView("staff/login", model);
    }
}
