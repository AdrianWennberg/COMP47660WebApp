package com.ed.webapp.controller;

import com.ed.webapp.model.Fees;
import com.ed.webapp.model.Student;
import com.ed.webapp.repository.FeesRepository;
import com.ed.webapp.repository.StudentRepository;
import com.ed.webapp.service.CheckRegistrationService;
import com.ed.webapp.service.StudentModuleService;
import com.ed.webapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    StudentModuleService studentModuleService;
    @Autowired
    StudentService studentService;
    @Autowired
    FeesRepository feeRepository;



    @GetMapping("/data")
    @ResponseBody
    public Map<String, Object> getStudentData() {
        HashMap<String, Object> studentData = new HashMap<>();

        studentData.put("nationalities", studentService.getStudentCountByNationality());
        studentData.put("genders", studentService.getStudentCountByGender());

        return studentData;
    }

    @GetMapping("/login")
    public ModelAndView loginPage(ModelMap model, HttpSession session) {
        if (session.getAttribute("student_user") != null) {
            return new ModelAndView(new RedirectView("/student/profile"));
        }
        model.addAttribute("student", new Student());
        return new ModelAndView("student/login", model);
    }

    @GetMapping("/profile")
    public ModelAndView profilePage(ModelMap model, HttpSession session) {
        Student user = (Student) session.getAttribute("student_user");
        if (user == null) {
            return new ModelAndView(new RedirectView("/student/login"));
        }
        user = studentService.updateStudent(user);
        session.setAttribute("student_user", user);
        return new ModelAndView("/student/profile", model);
    }

    @GetMapping("/registration")
    public ModelAndView registrationPage(ModelMap model, HttpSession session) {
        Student student = new Student();
        model.addAttribute("current_student", student);
        return new ModelAndView("/student/registration", model);
    }
    CheckRegistrationService checkRegistrationService=new CheckRegistrationService();
    @PostMapping("/registration")
    public RedirectView createStudent(ModelMap model, HttpSession session, @ModelAttribute Student student) {
        List<Student> found = studentRepository.findByUsername(student.getStd_username());
        if(checkRegistrationService.checkFields(student) && found.isEmpty() ){//&& studentService.getStudent(student)!=null){
                System.out.println(student);
                studentService.createStudent(student);
                return new RedirectView("/student/login");
        }
        else {
            model.addAttribute("registration_error", "Incorrect registration!");
            return new RedirectView("/");
        }
    }

    @GetMapping("/unregister")
    public ModelAndView unregisterPage(HttpSession session) {
        if (session.getAttribute("student_user") == null) {
            return new ModelAndView(new RedirectView("/student/login"));
        }
        return new ModelAndView("/student/unregister");
    }

    @PostMapping("/unregister")
    public ModelAndView Unregister(HttpSession session) {
        Student student = (Student) session.getAttribute("student_user");
        if (student == null) {
            return new ModelAndView(new RedirectView("/student/login"));
        }
        studentService.deleteStudent(student);
        session.removeAttribute("student_user");
        return new ModelAndView(new RedirectView("/"));
    }

    @PostMapping("/login")
    public ModelAndView login(ModelMap model, HttpSession session, @ModelAttribute Student student) {
        List<Student> found = studentRepository.findByUsername(student.getStd_username());
        if (found.size() == 1) {
            Student user = found.get(0);
            if (studentService.checkPassword(user)){//user.checkPassword(student.getStd_password())) {
                session.setAttribute("student_user", user);
                if (session.getAttribute("student_user") != null) {
                    return new ModelAndView(new RedirectView("/student/profile"));
                }
            }
        }
        else if (!found.isEmpty()) {
            throw new RuntimeException("Multiple student members found!");
        }
        model.addAttribute("login_error", "Incorrect login!");
        return new ModelAndView("/student/login", model);
    }

    @GetMapping("/fees")
    public ModelAndView studentFeesPage(ModelMap model, HttpSession session) {
        Student user = (Student) session.getAttribute("student_user");
        if (session.getAttribute("student_user") == null) {
            return new ModelAndView(new RedirectView("/student/login"));
        }
        List<Fees> previousFees = new LinkedList<>();
        for (Fees fee : feeRepository.findByFee_student(user)) {
            if (fee.getFee_year() != 2020) {
                previousFees.add(fee);
            }
            else {
                model.addAttribute("current_fees", fee);
            }
        }
        model.addAttribute("previous_fees", previousFees);
        return new ModelAndView("/student/fees", model);
    }

    @GetMapping("/pay/")
    public RedirectView payFees(HttpSession session) {
        Student user = (Student) session.getAttribute("student_user");
        if (user == null) {
            return new RedirectView("/student/login");
        }
        user = studentService.getStudent(user);
        for (Fees fee : feeRepository.findByFee_student(user)) {
            if (fee.getFee_year() == 2020) {
                fee.setPaid(true);
                fee.setFee_student(user);
                feeRepository.save(fee);
            }
        }
        return new RedirectView("/student/fees");
    }
}