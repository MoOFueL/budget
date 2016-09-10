package com.moofuel.budget.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author is D.Ivanov, created on 14.07.2016.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BudgetInternalException extends IllegalStateException {

    public BudgetInternalException(String message) {
        super(message);
    }
}
