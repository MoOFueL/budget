package com.moofuel.budget.backend.controllers;

import com.moofuel.budget.backend.domain.entities.User;
import com.moofuel.budget.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author is D.Ivanov, created on 07.07.2016.
 */
@SuppressWarnings("MVCPathVariableInspection")
@RestController
@RequestMapping(path = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public User findUserById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }
}
