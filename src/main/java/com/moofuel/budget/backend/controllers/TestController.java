package com.moofuel.budget.backend.controllers;

import com.moofuel.budget.backend.domain.entities.User;
import com.moofuel.budget.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MoOFueL on 02.07.2016.
 */
@RestController
@RequestMapping(path = "/test", produces = "application/json")
public class TestController {


    @Autowired
    private UserService userService;

    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    public User kek(@PathVariable("name") String name) {
        return userService.findByName(name);
    }

    @RequestMapping(path = "/save/{name}", method = RequestMethod.GET)
    public User kekkest(@PathVariable("name") String name) {
        return userService.saveForName(name);
    }
}
