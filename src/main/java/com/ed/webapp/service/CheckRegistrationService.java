package com.ed.webapp.service;

import com.ed.webapp.model.Student;

public class CheckRegistrationService {

    public boolean checkFields(Student student){

        if(student==null)return false;
        String username= student.getStd_username();
        String name = student.getStd_name();
        String surname = student.getStd_surname();
        String email = student.getStd_email();
        String address = student.getStd_address();
        String pwd = student.getStd_password();
        String nationality = student.getStd_nationality();

        boolean flag=(username.matches("\\w+"));
                        //(name.matches("[:alpha:]+")) &&
                       // (surname.matches("[:alpha:]+")) &&
                        //(email.matches("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,4}")) &&
                       // (!address.isEmpty()) &&
                        //(pwd.matches("\\w+"));//&&
                        //(nationality.matches("[:alpha:]+"));
        if(flag)System.out.println("true");
        else System.out.println("false");
        return flag;
    }
}
