package com.moofuel.budget.backend.controllers;

import com.moofuel.budget.backend.domain.entities.PayCheck;
import com.moofuel.budget.backend.services.PayCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by MoOFueL on 07.07.2016.
 */
@RestController
@RequestMapping(path = "/paychecks", produces = "application/json")
public class PayCheckController {


    @Autowired
    private PayCheckService payCheckService;


    @RequestMapping(path = "/user/{userId}", method = RequestMethod.GET)
    private List<PayCheck> findAllChecksByUserId(@PathVariable("userId") Integer userId) {
        return payCheckService.findByuserId(userId);
    }
}
