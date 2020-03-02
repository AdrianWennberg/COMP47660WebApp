package com.ed.webapp.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

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
    @Column(unique = true)
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

    public String getUsername() {
        return stf_username;
    }

    public void setUsername(String stf_username) {
        this.stf_username = stf_username;
    }

    public String getSurname() {
        return stf_surname;
    }

    public void setSurname(String stf_surname) {
        this.stf_surname = stf_surname;
    }

    public SEX getSx() {
        return stf_sex;
    }

    public void setSex(SEX stf_sex) {
        this.stf_sex = stf_sex;
    }

    public String getPassword() {
        return stf_password;
    }

    public void setPassword(String stf_password) {
        this.stf_password = stf_password;
    }

    public boolean checkPassword(String password) {
        return stf_password.equals(password);
    }

    public String getName() {
        return stf_name;
    }

    public void setName(String stf_name) {
        this.stf_name = stf_name;
    }

    public long getID() {
        return stf_ID;
    }

    @Override
    public String toString() {
        return "Staff{" + "stf_ID=" + stf_ID + ", stf_password='" + stf_password + '\'' + ", stf_name='" + stf_name + '\'' + ", stf_surname='" + stf_surname + '\'' + ", stf_username='" + stf_username + '\'' + ", stf_sex=" + stf_sex + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Staff staff = (Staff) o;
        return stf_ID == staff.stf_ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stf_ID);
    }
}
