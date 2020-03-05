package com.ed.webapp.repository;

import com.ed.webapp.model.Student;
import com.ed.webapp.model.StudentModule;
import com.ed.webapp.model.StudentModuleID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedQuery;
import java.util.List;

public interface StudentModuleRepository extends JpaRepository<StudentModule, StudentModuleID> {

    @Query(value = "SELECT * from studentmodule where stmd_student = ?1", nativeQuery = true)
    List<StudentModule> findByStudent(Student student);
}
