package com.ed.webapp.service;

import com.ed.webapp.model.Student;
import com.ed.webapp.repository.StudentRepository;
import com.ed.webapp.security.BlockedIPException;
import com.ed.webapp.security.LoginAttemptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
public class StudentUserDetailsService implements UserDetailsService {

    @Autowired
    public StudentRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(StudentUserDetailsService.class);

    @Autowired
    private LoginAttemptService loginAttemptService;

    @Autowired
    private HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<Student> user = repository.findByUsername(username);
        String ip = getClientIP();
        if (loginAttemptService.isBlocked(ip)) {
            logger.info(" blocked IP: "+ip);
            throw new BlockedIPException("blocked IP: "+ip);

        }
        if (user.isEmpty()) {
            logger.info(username+" tried to login in");
            throw new UsernameNotFoundException("blocked");
        }
        Student student = user.get();
        logger.info(username+" is logging in ");
        return User.withUsername(student.getStd_username())
                   .password(student.getStd_password())
                   .roles(student.getRole())
                   .build();
    }

    private String getClientIP() {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null){
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }

}