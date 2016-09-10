package com.moofuel.budget.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author is D.Ivanov, created on 14.07.2016.
 */
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class AuthorizationException extends IllegalStateException {

    public AuthorizationException(String s) {
        super(s);
    }
}
