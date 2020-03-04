package com.ed.webapp.repository;

import com.ed.webapp.model.Staff;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ed.webapp.model.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    @Query(value = "SELECT * from student where std_username = ?1", nativeQuery = true)
    List<Student> findByUsername(String username);
}



