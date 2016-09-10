package com.moofuel.budget.backend.controllers;

import com.moofuel.budget.backend.domain.entities.PayCheck;
import com.moofuel.budget.backend.services.PayCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * Author is D.Ivanov, created on 07.07.2016.
 */
@RestController
@RequestMapping(path = "/paychecks", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PayCheckController {


    @Autowired
    private PayCheckService payCheckService;


    @RequestMapping(path = "/users/{userId}", method = RequestMethod.GET)
    private List<PayCheck> findAllChecksByUserId(@PathVariable("userId") Integer userId) {
        return payCheckService.findByUserId(userId);
    }

    @RequestMapping(path = "/users/{userId}", method = RequestMethod.POST)
    private PayCheck createPaycheck(@PathVariable("userId") Integer userId,
                                    @RequestBody @Valid PayCheck payCheck) {
        return payCheckService.createNewPaycheck(userId, payCheck);
    }
}
