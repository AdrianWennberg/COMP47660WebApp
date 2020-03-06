package com.ed.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @GetMapping("logout")
    public RedirectView logout(HttpSession session) {
        session.removeAttribute("staff_user");
        session.removeAttribute("student_user");
        return new RedirectView("/");
    }
}
