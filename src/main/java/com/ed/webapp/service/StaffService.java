package com.ed.webapp.service;

import com.ed.webapp.model.Staff;
import com.ed.webapp.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    StaffRepository repository;

    public Optional<Staff> getStaffMember(Staff staff) {
        List<Staff> foundUsers = repository.findByUsername(staff.getStf_username());
        if (foundUsers.size() > 1) {
            throw new DataIntegrityViolationException("Multiple staff members with same username exist: " +
                                                              staff.getStf_username());
        }
        if (foundUsers.isEmpty()) {
            return Optional.empty();
        }
        Staff user = foundUsers.get(0);
        if (!user.checkPassword(staff.getStf_password())) {
            return Optional.empty();
        }
        return Optional.of(user);
    }

    public Staff updateStaffMember(Staff staff) {
        return getStaffMember(staff).orElseThrow();
    }

    public long getStaffCount() {
        return repository.count();
    }
}
