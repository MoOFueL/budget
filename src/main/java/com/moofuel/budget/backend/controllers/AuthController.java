package com.moofuel.budget.backend.controllers;

import com.moofuel.budget.backend.domain.entities.User;
import com.moofuel.budget.backend.exceptions.AuthorizationException;
import com.moofuel.budget.backend.exceptions.NotFoundException;
import com.moofuel.budget.backend.misc.AuthObject;
import com.moofuel.budget.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Author is D.Ivanov, created on 14.07.2016.
 */
@RestController
@RequestMapping(path = "/auth", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AuthController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public User authorize(@RequestBody @Valid AuthObject authObject) {

        User user;
        try {
            user = userService.findByCredentials(authObject);
        } catch (NotFoundException ex) {
            throw new AuthorizationException("Not authorized!");
        }

        return userService.updateUser(user);
    }
}
