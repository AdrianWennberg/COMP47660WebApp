package com.ed.webapp.repository;

import com.ed.webapp.model.Student;
import com.ed.webapp.model.StudentModule;
import com.ed.webapp.model.StudentModuleID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.util.List;
@Repository
public interface StudentModuleRepository extends JpaRepository<StudentModule, StudentModuleID> {

    @Query(value = "SELECT * from studentmodule where std_id = ?1", nativeQuery = true)
    List<StudentModule> findByStd_id(long id);
}
