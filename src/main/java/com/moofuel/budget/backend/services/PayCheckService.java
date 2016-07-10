package com.moofuel.budget.backend.services;

import com.moofuel.budget.backend.domain.entities.PayCheck;
import com.moofuel.budget.backend.exceptions.CantCreateEntityException;
import com.moofuel.budget.backend.repositories.PayCheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MoOFueL on 07.07.2016.
 */
@Service
public class PayCheckService {

    @Autowired
    private PayCheckRepository payCheckRepository;

    @Autowired
    private FileService fileService;

    public PayCheck findById(Integer userId) {
        return payCheckRepository.findById(userId);
    }

    public PayCheck createNewPaycheck(PayCheck payCheck) {
        if (payCheck.getId() != null) {
            throw new CantCreateEntityException("If you want to create entity than you mustn't specify ID field!");
        }
        if (payCheck.getImages() != null && !payCheck.getImages().isEmpty()) {
            fileService.createNewFiles(payCheck.getImages());
        }
        return payCheckRepository.save(payCheck);
    }
}
