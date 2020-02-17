package com.ed.webapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="students")
public class Student {
    private enum SEX{MALE,FEMALE}
    @Id
    @GeneratedValue
    private long std_ID;
    @NotBlank
    private String std_password;
    @NotBlank
    private String std_name;
    @NotBlank
    private String std_surname;
    @NotBlank
    private String std_address;
    @NotBlank
    private String std_username;
    @NotBlank
    private String std_email;
    @NotBlank
    private SEX std_sex;

    public Student(){
        super();
    }
    public Student(String username,String password,String name,String surname,String address,long ID,String email,char sex){
        std_username=username;
        std_password=password;
        std_name=name;
        std_surname=surname;
        std_address=address;
        std_ID=ID;
        std_email=email;
        if(sex=='m' || sex == 'M')
            std_sex=SEX.MALE;
        else if (sex=='f' || sex=='F')
            std_sex=SEX.FEMALE;
        else throw new IllegalArgumentException();
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

    public String getStd_name() {
        return std_name;
    }

    public void setStd_name(String std_name) {
        this.std_name = std_name;
    }

    public long getStd_ID() {
        return std_ID;
    }

    public void setStd_ID(long std_ID) {
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
}