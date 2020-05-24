package com.ed.webapp.service;

import com.ed.webapp.model.Student;
import com.ed.webapp.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentUserDetailsService implements UserDetailsService {

    @Autowired
    public StudentRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(StudentUserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<Student> user = repository.findByUsername(username);

        if (user.isEmpty()) {
            logger.info(username+"tried to login in");
            throw new UsernameNotFoundException("User not found by name: " + username);
        }
        Student student = user.get();
        logger.info(username+" logins");
        return User.withUsername(student.getStd_username())
                   .password(student.getStd_password())
                   .roles(student.getRole())
                   .build();
    }
}