package com.ed.webapp.service;

import com.ed.webapp.model.Fees;
import com.ed.webapp.repository.FeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeesService {

    @Autowired
    FeesRepository repository;

    public void deleteFees(Fees fees) {
        repository.delete(fees);
    }

    public void payFees(Fees fees) {
        fees.setPaid(true);
        repository.save(fees);
    }
}
