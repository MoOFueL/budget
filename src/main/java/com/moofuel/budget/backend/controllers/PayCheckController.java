package com.moofuel.budget.backend.controllers;

import com.moofuel.budget.backend.domain.entities.PayCheck;
import com.moofuel.budget.backend.services.PayCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * Created by MoOFueL on 07.07.2016.
 */
@RestController
@RequestMapping(path = "/paychecks", produces = "application/json")
public class PayCheckController {


    @Autowired
    private PayCheckService payCheckService;


    @RequestMapping(path = "/users/{userId}", method = RequestMethod.GET)
    private PayCheck findAllChecksByUserId(@PathVariable("userId") Integer userId) {
        return payCheckService.findById(userId);
    }

    @RequestMapping(path = "/users/{userId}", method = RequestMethod.POST)
    private PayCheck createPaycheck(@RequestBody @Valid PayCheck payCheck) {
        return payCheckService.createNewPaycheck(payCheck);
    }
}
