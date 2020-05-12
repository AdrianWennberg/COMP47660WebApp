package com.ed.webapp.service;

import com.ed.webapp.model.*;
import com.ed.webapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    @Autowired
    FeesService feesService;

    @Autowired
    StudentModuleService studentModuleService;

    public List<Student> getAllStudents() {return repository.findAll();}

    public List<Student> getStudentByUsername(String username) {return repository.findByUsername(username);}

    public Student createStudent(Student new_student) {
        return repository.save(new_student);
    }

    public long getStudentCount() {
        return repository.count();
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

    public Student getStudent(Student user) {
        return repository.findById(user.getStd_ID()).orElseThrow();
    }

    public Student updateStudent(Student student) {
        return getStudent(student);
    }

    public Map<String, Integer> getStudentCountByNationality() {
        HashMap<String, Integer> count = new HashMap<>();

        for (Student student : getAllStudents()) {
            String nationality = student.getStd_nationality();
            Integer current = count.getOrDefault(nationality, 0);
            count.put(nationality, current + 1);
        }
        return count;
    }

    public Map<String, Integer> getStudentCountByGender() {
        HashMap<String, Integer> count = new HashMap<>();

        for (Student student : getAllStudents()) {
            String gender = student.getStd_sex().toString();
            Integer current = count.getOrDefault(gender, 0);
            count.put(gender, current + 1);
        }
        return count;
    }
}
