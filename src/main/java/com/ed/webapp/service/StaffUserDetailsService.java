package com.ed.webapp.service;

import com.ed.webapp.model.Staff;
import com.ed.webapp.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StaffUserDetailsService implements UserDetailsService {

    @Autowired
    public StaffRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<Staff> user = repository.findByUsername(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found by name: " + username);
        }
        Staff staff = user.get();

        return User.withUsername(staff.getStf_username())
                   .password(staff.getStf_password())
                   .roles(staff.getRole())
                   .build();
    }
}