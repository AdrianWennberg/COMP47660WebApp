package com.ed.webapp.controller;

import com.ed.webapp.model.Fees;
import com.ed.webapp.model.Student;
import com.ed.webapp.repository.FeesRepository;
import com.ed.webapp.repository.StudentRepository;
import com.ed.webapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    public RedirectView createStudent(ModelMap model, HttpSession session, @Valid @ModelAttribute Student student, BindingResult bindingResult) {
        List<Student> found = studentRepository.findByUsername(student.getStd_username());
        if(bindingResult.hasErrors()) {
            System.out.println("errore");
            model.addAttribute("registration_error", "Incorrect registration!");
            return new RedirectView("/student/registration");
        }
        if(checkRegistrationService.checkFields(student) && found.isEmpty() ){//&& studentService.getStudent(student)!=null){
                System.out.println(student);
                studentService.createStudent(student);
                return new RedirectView("/student/login");
        }
        else {
            model.addAttribute("registration_error", "Incorrect registration!");
            return new RedirectView("/student/registration");
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
        Optional<Student> studentOptional = studentService.confirmLogin(student);
        if (studentOptional.isEmpty()) {

            model.addAttribute("login_error", "Incorrect login!");
            return new ModelAndView("/student/login", model);
        }

        session.setAttribute("student_user", studentOptional.get());
        return new ModelAndView(new RedirectView("/student/profile"));
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