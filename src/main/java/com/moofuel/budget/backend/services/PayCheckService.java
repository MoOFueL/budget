package com.moofuel.budget.backend.services;

import com.moofuel.budget.backend.domain.entities.PayCheck;
import com.moofuel.budget.backend.exceptions.CantCreateEntityException;
import com.moofuel.budget.backend.repositories.PayCheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * Author is D.Ivanov, created on 07.07.2016.
 */
@Service
public class PayCheckService {

    @Autowired
    private PayCheckRepository payCheckRepository;

    @Autowired
    private FileService fileService;

    @Autowired
    private UserService userService;

    public List<PayCheck> findByUserId(Integer userId) {
        return payCheckRepository.findByUserId(userId);
    }

    public PayCheck createNewPaycheck(Integer userId, PayCheck payCheck) {

        if (payCheck.getId() != null) {
            throw new CantCreateEntityException("If you want to create entity than you mustn't specify ID field!");
        }
        payCheck.setUserId(userId);
        if (payCheck.getImages() != null && !payCheck.getImages().isEmpty()) {
            payCheck.setImages(new HashSet<>(fileService.createNewFiles(payCheck.getImages())));
        }
        return payCheckRepository.save(payCheck);
    }
}
