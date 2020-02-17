package com.ed.webapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.Year;

@Entity
@IdClass(StudentModuleID.class)
@Table(name ="studentmodule")
public class StudentModule implements Serializable {
    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn
    private Student stmd_student;

    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn
    private Module stmd_module;

    @NotBlank
    private Year stmd_year;

    private double grade;

    public StudentModule(){
        super();
    }

    public StudentModule(Student student, Module module, Year year){
        stmd_student = student;
        stmd_module = module;
        stmd_year = year;
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

    public Year getStmd_year() {
        return stmd_year;
    }

    public void setStmd_year(Year stmd_year) {
        this.stmd_year = stmd_year;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}