package com.app.longestpalindrome.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidStringException extends RuntimeException {

    public InvalidStringException(String message) {
        super(message);
    }

}
