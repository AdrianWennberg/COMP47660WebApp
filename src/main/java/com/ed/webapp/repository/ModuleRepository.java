package com.ed.webapp.repository;

import com.ed.webapp.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

    @Query(value = "SELECT * from module where stf_id = ?1", nativeQuery = true)
    List<Module> findByStf_ID(long id);
}
