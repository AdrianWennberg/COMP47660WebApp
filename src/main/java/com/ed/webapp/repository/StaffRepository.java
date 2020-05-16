package com.ed.webapp.repository;

import com.ed.webapp.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

    @Query(value = "SELECT * from staff where stf_username = ?1", nativeQuery = true)
    Optional<Staff> findByUsername(String username);
}

