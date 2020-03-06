package com.ed.webapp.repository;

import com.ed.webapp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeesRepository extends JpaRepository<Fees, FeesID> {
    @Query(value = "SELECT * from fees where fee_student_std_id = ?1", nativeQuery = true)
    List<Fees> findByFee_student(Student student);
}