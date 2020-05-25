package com.ed.webapp.service;

import com.ed.webapp.model.Staff;
import com.ed.webapp.repository.StaffRepository;
import com.ed.webapp.security.BlockedIPException;
import com.ed.webapp.security.LoginAttemptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
public class StaffUserDetailsService implements UserDetailsService {

    @Autowired
    public StaffRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(StaffUserDetailsService.class);

    @Autowired
    private LoginAttemptService loginAttemptService;

    @Autowired
    private HttpServletRequest request;


    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<Staff> user = repository.findByUsername(username);
        String ip = getClientIP();
        if (loginAttemptService.isBlocked(ip)) {
            logger.info(" blocked IP: "+ip);
            throw new BlockedIPException("blocked IP: "+ip);
        }
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found by name: " + username);
        }
        Staff staff = user.get();
        logger.info("the staff "+ username+" is loggin in");
        return User.withUsername(staff.getStf_username())
                   .password(staff.getStf_password())
                   .roles(staff.getRole())
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