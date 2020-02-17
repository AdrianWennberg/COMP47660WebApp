package com.ed.webapp.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "staff")
public class Staff {
    public enum SEX {MALE, FEMALE}

    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long stf_ID;
    @NotBlank
    private String stf_password;
    @NotBlank
    private String stf_name;
    @NotBlank
    private String stf_surname;
    @NotBlank
    private String stf_username;
    @NotNull
    private SEX stf_sex;

    public Staff() {
        super();
    }

    public Staff(String username, String password, String name, String surname, char s) {
        stf_username = username;
        stf_password = password;
        stf_name = name;
        stf_surname = surname;
        if (s == 'm' || s == 'M') {
            stf_sex = SEX.MALE;
        }
        else if (s == 'f' || s == 'F') {
            stf_sex = SEX.FEMALE;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public String getStf_username() {
        return stf_username;
    }

    public void setStf_username(String stf_username) {
        this.stf_username = stf_username;
    }

    public String getStf_surname() {
        return stf_surname;
    }

    public void setStf_surname(String stf_surname) {
        this.stf_surname = stf_surname;
    }

    public SEX getStf_sex() {
        return stf_sex;
    }

    public void setStf_sex(SEX stf_sex) {
        this.stf_sex = stf_sex;
    }

    public String getStf_password() {
        return stf_password;
    }

    public void setStf_password(String stf_password) {
        this.stf_password = stf_password;
    }

    public String getStf_name() {
        return stf_name;
    }

    public void setStf_name(String stf_name) {
        this.stf_name = stf_name;
    }

    public long getStf_ID() {
        return stf_ID;
    }

    @Override
    public String toString() {
        return "Staff{" + "stf_ID=" + stf_ID + ", stf_password='" + stf_password + '\'' + ", stf_name='" + stf_name + '\'' + ", stf_surname='" + stf_surname + '\'' + ", stf_username='" + stf_username + '\'' + ", stf_sex=" + stf_sex + '}';
    }
}
