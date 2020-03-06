package com.ed.webapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "studentmodule")
public class StudentModule {

    @EmbeddedId
    StudentModuleID id;

    @ManyToOne
    @MapsId("stmd_student_id")
    @JoinColumn(name = "stmd_student_id")
    private Student stmd_student;

    @ManyToOne
    @MapsId("stmd_module_id")
    @JoinColumn(name = "stmd_module_id")
    private Module stmd_module;

    @NotNull
    private int stmd_year;

    @NotNull
    private int stmd_semester;

    private double grade;

    public StudentModule() {
        super();
    }

    public StudentModuleID getId() {
        return id;
    }

    public void setId(StudentModuleID id) {
        this.id = id;
    }

    public int getStmd_year() {
        return stmd_year;
    }

    public void setStmd_year(int stmd_year) {
        this.stmd_year = stmd_year;
    }

    public StudentModule(Student student, Module module, int year, int semester) {
        stmd_student = student;
        stmd_module = module;
        stmd_year = year;
        stmd_semester = semester;
    }

    public Student getStmd_student() {
        return stmd_student;
    }

    public void setStmd_student(Student stmd_student) {
        this.stmd_student = stmd_student;
    }

    public Module getStmd_module() {
        return stmd_module;
    }

    public void setStmd_module(Module stmd_module) {
        this.stmd_module = stmd_module;
    }

    public int getStmd_semester() {return stmd_semester;    }

    public void setStmd_semester(int stmd_semester) {this.stmd_semester = stmd_semester; }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
