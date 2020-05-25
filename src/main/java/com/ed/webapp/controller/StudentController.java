package com.ed.webapp.controller;

import com.ed.webapp.model.Fees;
import com.ed.webapp.model.Student;
import com.ed.webapp.repository.StudentRepository;
import com.ed.webapp.service.CheckRegistrationService;
import com.ed.webapp.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentService studentService;

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);


    @GetMapping("/data")
    @ResponseBody
    public Map<String, Object> getStudentData() {
        HashMap<String, Object> studentData = new HashMap<>();

        studentData.put("nationalities", studentService.getStudentCountByNationality());
        studentData.put("genders", studentService.getStudentCountByGender());
        return studentData;
    }

    @GetMapping("/login")
    public ModelAndView loginPage(@AuthenticationPrincipal UserDetails user) {
        if (user != null) {
            return new ModelAndView(new RedirectView("/"));
        }
        return new ModelAndView("/student/login");
    }


    @GetMapping("/profile")
    public ModelAndView profilePage(@AuthenticationPrincipal UserDetails user, ModelMap model) {
        Student student = studentService.getUser(user);
        student = studentService.updateStudent(student);

        model.addAttribute("student_user", student);
        return new ModelAndView("/student/profile", model);
    }

    @GetMapping("/registration")
    public ModelAndView registrationPage(ModelMap model) {
        Student student = new Student();
        model.addAttribute("current_student", student);
        return new ModelAndView("/student/registration", model);
    }

    CheckRegistrationService checkRegistrationService=new CheckRegistrationService();

    @PostMapping("/registration")
    public RedirectView createStudent(ModelMap model, @Valid @ModelAttribute Student student, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            logger.info("Registration failed");
            model.addAttribute("registration_error", "Incorrect registration!");
            return new RedirectView("/student/registration");
        }

        if (!studentService.studentExists(student.getStd_username())) {
            logger.info("Registration failed");
            model.addAttribute("registration_error", "Incorrect registration!");
            return new RedirectView("/student/registration");
        }

        if (!checkRegistrationService.checkFields(student)) {
            logger.info("Registration failed");
            model.addAttribute("registration_error", "Incorrect registration!");
            return new RedirectView("/student/registration");
        }

        studentService.createStudent(student);
        logger.info(student.getStd_username()+" is registered");
        return new RedirectView("/student/login");
    }

    @GetMapping("/unregister")
    public ModelAndView unregisterPage() {
        return new ModelAndView("/student/unregister");
    }

    @PostMapping("/unregister")
    public ModelAndView Unregister(@AuthenticationPrincipal UserDetails user, HttpSession session) {
        Student student = studentService.getUser(user);
        studentService.deleteStudent(student);

        session.invalidate();
        return new ModelAndView(new RedirectView("/"));
    }

    @GetMapping("/fees")
    public ModelAndView studentFeesPage(@AuthenticationPrincipal UserDetails user, ModelMap model) {
        Student student = studentService.getUser(user);

        List<Fees> previousFees = new LinkedList<>();
        for (Fees fee : student.getFees()) {
            if (fee.getFee_year() != 2020) {
                previousFees.add(fee);
            }
            else {
                model.addAttribute("current_fees", fee);
            }
        }
        model.addAttribute("previous_fees", previousFees);
        model.addAttribute("username", student.getStd_username());
        return new ModelAndView("/student/fees", model);
    }

    @PostMapping("/pay")
    public RedirectView payFees(@AuthenticationPrincipal UserDetails user) {
        Student student = studentService.getUser(user);

        studentService.payFees(student);
        return new RedirectView("/student/fees");
    }
}