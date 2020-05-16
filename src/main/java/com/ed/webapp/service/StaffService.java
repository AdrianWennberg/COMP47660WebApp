package com.ed.webapp.service;

import com.ed.webapp.model.Staff;
import com.ed.webapp.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    StaffRepository repository;

    public Optional<Staff> getStaffMember(Staff staff) {
        Optional<Staff> user = repository.findByUsername(staff.getStf_username());

        if (user.isEmpty() || !user.get().checkPassword(staff.getStf_password())) {
            return Optional.empty();
        }
        return user;
    }

    public boolean isStaff(UserDetails user) {
        return user.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_Staff"));
    }

    public Staff getUser(UserDetails user) {
        return getStaffMemberByName(user.getUsername());
    }

    public Staff updateStaffMember(Staff staff) {
        return getStaffMember(staff).orElseThrow();
    }

    public long getStaffCount() {
        return repository.count();
    }

    public Staff getStaffMemberByName(String username) {
        return repository.findByUsername(username).orElseThrow();
    }
}
