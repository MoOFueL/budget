package com.moofuel.budget.backend.services;

import com.moofuel.budget.backend.domain.entities.PayCheck;
import com.moofuel.budget.backend.repositories.PayCheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MoOFueL on 07.07.2016.
 */
@Service
public class PayCheckService {

    @Autowired
    private PayCheckRepository payCheckRepository;

    public List<PayCheck> findByuserId(Integer userId) {
        return payCheckRepository.findByUserId(userId);
    }
}
