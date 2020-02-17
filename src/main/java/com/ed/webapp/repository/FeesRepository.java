package com.ed.webapp.repository;

import com.ed.webapp.model.Fees;
import com.ed.webapp.model.FeesID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeesRepository extends JpaRepository<Fees, FeesID> {
}