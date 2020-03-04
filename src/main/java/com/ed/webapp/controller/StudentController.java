package com.ed.webapp.controller;

import com.ed.webapp.repository.StudentRepository;
import com.ed.webapp.exception.StudentNotFoundException;
import com.ed.webapp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/student")
    @ResponseBody
    public List<Student> getStudent(){return studentRepository.findAll();}


    @GetMapping("/student/studentlogin")
    public ModelAndView loginPage(ModelMap model, HttpSession session){
        if(session.getAttribute("student_user")!=null){
            return new ModelAndView(new RedirectView("/"));
        }
        model.addAttribute("student",new Student());
        return new ModelAndView("student/studentlogin",model);
    }


    @GetMapping
    public ModelAndView profilePage(ModelMap model, HttpSession session){
        if(session.getAttribute("student_user")==null){
            return new ModelAndView(new RedirectView("/student/studentlogin"));
        }
        return new ModelAndView("student/profile",model);
    }

    @PostMapping("/student/studentlogin")
    public ModelAndView login(ModelMap model, HttpSession session, @ModelAttribute Student student){
        List<Student>found = studentRepository.findByUsername(student.getStd_username());
        if(found.size()==1){
            Student user=found.get(0);
            if(user.checkPassword(student.getStd_password())){
                session.setAttribute("student_user",user);
                if(session.getAttribute("student_user")!=null){
                    return new ModelAndView(new RedirectView("/student/studentprofile"));
                }
            }
        }
        else if (found.isEmpty()){
            System.out.println("Error");
        }
        else{
            throw new RuntimeException("Multiple student members found!");
        }
        model.addAttribute("login_error","Incorrect login!");
        return new ModelAndView("student/studentlogin",model);
    }

    /*
    @GetMapping("studentId")
    @ResponseBody
    public Student getStudentById(@PathVariable(value = "id") Long studentId) throws StudentNotFoundException {
        return studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException(studentId));
    }
    @GetMapping("studentUser")
    @ResponseBody
    public Student getStudentByUsername(@PathVariable(value = "std_username") String std_username)  {
        return (Student) studentRepository.findByUsername(std_username);
    }
    @PutMapping("/students/{id}")
    @ResponseBody
    //We only update the data of an existing student and we do not change his/her ID
    public Student updateStudent(@PathVariable(value = "id") Long studentId
            , @Valid @RequestBody Student student_details) throws StudentNotFoundException {
        Student student = studentRepository.findById(studentId).orElse(new Student());
        student.setStd_ID(student_details.getStd_ID());
        student.setStd_name(student_details.getStd_name());
        student.setStd_username(student_details.getStd_username());
        student.setStd_address(student_details.getStd_address());
        student.setStd_email(student_details.getStd_email());
        student.setStd_password(student_details.getStd_password());
        student_details.setStd_sex(student_details.getStd_sex());

        return studentRepository.save(student);
    }
    @DeleteMapping("/students/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookId) throws StudentNotFoundException {
        Student book = studentRepository.findById(bookId).orElseThrow(() -> new StudentNotFoundException(bookId));

        studentRepository.delete(book);

        return ResponseEntity.ok().build();
    }
   */


}