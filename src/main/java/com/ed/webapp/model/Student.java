package com.ed.webapp.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "student")
public class Student {

    public enum SEX {MALE, FEMALE}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long std_ID;
    @NotBlank
    private String std_password;
    @NotBlank
    private String std_name;
    @NotBlank
    private String std_surname;
    @NotBlank
    private String std_address;
    @NotBlank
    @Column(unique = true)
    private String std_username;
    @NotBlank
    private String std_email;
    @NotBlank
    private String std_nationality;
    @NotNull
    private SEX std_sex;

    @OneToMany(mappedBy = "fee_student", fetch = FetchType.EAGER)
    List<Fees> fees;

    @OneToMany(mappedBy = "stmd_student", fetch = FetchType.EAGER)
    Set<StudentModule> modules;

    @Override
    public int hashCode() {
        return Objects.hash(std_ID);
    }

    public Student() {
        super();
    }

    public Student(String username, String password, String name, String surname, String address, long ID, String email, char sex, String nationality) {
        std_nationality = nationality;
        std_username = username;
        std_password = password;
        std_name = name;
        std_surname = surname;
        std_address = address;
        std_ID = ID;
        std_email = email;
        std_nationality = nationality;
        if (sex == 'm' || sex == 'M') {
            std_sex = SEX.MALE;
        }
        else if (sex == 'f' || sex == 'F') {
            std_sex = SEX.FEMALE;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public String getStd_username() {
        return std_username;
    }

    public void setStd_username(String std_username) {
        this.std_username = std_username;
    }

    public String getStd_surname() {
        return std_surname;
    }

    public void setStd_surname(String std_surname) {
        this.std_surname = std_surname;
    }

    public SEX getStd_sex() {
        return std_sex;
    }

    public void setStd_sex(SEX std_sex) {
        this.std_sex = std_sex;
    }

    public String getStd_password() {
        return std_password;
    }

    public void setStd_password(String std_passwrd) {
        this.std_password = std_passwrd;
    }

    public boolean checkPassword(String password) {
        return std_password.equals(password);
    }

    public String getStd_name() {
        return std_name;
    }

    public void setStd_name(String std_name) {
        this.std_name = std_name;
    }

    public Long getStd_ID() {
        return std_ID;
    }

    public void setStd_ID(Long std_ID) {
        this.std_ID = std_ID;
    }

    public String getStd_address() {
        return std_address;
    }

    public void setStd_address(String std_address) {
        this.std_address = std_address;
    }

    public String getStd_email() {
        return std_email;
    }

    public void setStd_email(String std_email) {
        this.std_email = std_email;
    }

    public String getStd_nationality() {return std_nationality; }

    public void setStd_nationality(String std_nationality) {this.std_nationality = std_nationality; }

    public List<Fees> getFees() {
        return fees;
    }

    public void setFees(List<Fees> fees) {
        this.fees = fees;
    }

    public Set<StudentModule> getModules() {
        return modules;
    }

    public void setModules(Set<StudentModule> modules) {
        this.modules = modules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return std_ID.equals(student.std_ID);
    }

    @Override
    public String toString() {
        return "Student{" +
                "std_ID=" + std_ID +
                ", std_password='" + std_password + '\'' +
                ", std_name='" + std_name + '\'' +
                ", std_surname='" + std_surname + '\'' +
                ", std_address='" + std_address + '\'' +
                ", std_username='" + std_username + '\'' +
                ", std_email='" + std_email + '\'' +
                ", std_sex=" + std_sex +
                '}';
    }

}
