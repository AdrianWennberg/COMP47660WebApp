package com.ed.webapp.service;

import com.ed.webapp.WebSecurityConfig;
import com.ed.webapp.model.*;
import com.ed.webapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    @Autowired
    FeesService feesService;

    @Autowired
    StudentModuleService studentModuleService;

    public void createStudent(Student new_student) {
        new_student.setStd_password(WebSecurityConfig.encoder().encode(new_student.getStd_password()));
        repository.save(new_student);
    }

    public boolean isStudent(UserDetails user) {
        return user.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_Student"));
    }

    public Student getUser(UserDetails user) {
        return getStudentByUsername(user.getUsername());
    }

    public boolean studentExists(String username) {
        return repository.findByUsername(username).isPresent();
    }

    public Student getStudentByUsername(String username) {
        return repository.findByUsername(username).orElseThrow();
    }

    public Student updateStudent(Student student) {
        return repository.findById(student.getStd_ID()).orElseThrow();
    }

    public void payFees(Student user) {
        for (Fees fees : user.getFees()) {
            if (fees.getFee_year() == 2020) {
                feesService.payFees(fees);
            }
        }
    }

    public void deleteStudent(Student student) {
        student = repository.getOne(student.getStd_ID());
        for (Fees fees : student.getFees()) {
            feesService.deleteFees(fees);
        }

        for (StudentModule module : student.getModules()) {
            studentModuleService.deleteStudentModule(module);
        }

        repository.delete(student);
    }

    public long getStudentCount() {
        return repository.count();
    }

    public Map<String, Integer> getStudentCountByNationality() {
        HashMap<String, Integer> count = new HashMap<>();

        for (Student student : repository.findAll()) {
            String nationality = student.getStd_nationality();
            Integer current = count.getOrDefault(nationality, 0);
            count.put(nationality, current + 1);
        }
        return count;
    }

    public Map<String, Integer> getStudentCountByGender() {
        HashMap<String, Integer> count = new HashMap<>();

        for (Student student : repository.findAll()) {
            String gender = student.getStd_sex().toString();
            Integer current = count.getOrDefault(gender, 0);
            count.put(gender, current + 1);
        }
        return count;
    }

}
