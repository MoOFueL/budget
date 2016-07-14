package com.moofuel.budget.backend.controllers;

import com.moofuel.budget.backend.domain.entities.User;
import com.moofuel.budget.backend.exceptions.AuthorizationException;
import com.moofuel.budget.backend.exceptions.NotFoundException;
import com.moofuel.budget.backend.misc.AuthObject;
import com.moofuel.budget.backend.misc.GeneralResponse;
import com.moofuel.budget.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by MoOFueL on 14.07.2016.
 */
@RestController
@RequestMapping(path = "/auth")
public class AuthController {


    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public GeneralResponse authorize(@RequestBody @Valid AuthObject authObject) {
        User user;
        try {
            user = userService.findByCredentials(authObject);
        } catch (NotFoundException ex) {
            throw new AuthorizationException("Not authorized!");
        }
        user.setSynchronizedAt(new Date());
        user.setActive(true);
        userService.updateUser(user);
        return new GeneralResponse();
    }
}
