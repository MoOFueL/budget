package com.moofuel.budget.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by MoOFueL on 09.07.2016.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends IllegalStateException {

    public NotFoundException(String message) {
        super(message);
    }

}
