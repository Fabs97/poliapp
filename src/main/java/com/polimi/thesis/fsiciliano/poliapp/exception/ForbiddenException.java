package com.polimi.thesis.fsiciliano.poliapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ForbiddenException extends Exception{

    private static final long serialVersionUID = 4L;

    public ForbiddenException(String message) {
        super(message);
    }
}
