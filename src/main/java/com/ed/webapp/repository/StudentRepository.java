package com.ed.webapp.repository;

import com.ed.webapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    @Query(value = "SELECT * from student where std_username = ?1", nativeQuery = true)
    Optional<Student> findByUsername(String username);
}



