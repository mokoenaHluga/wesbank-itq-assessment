package com.itq.assessment.exception;

public class NoUserFoundException extends RuntimeException {
    public NoUserFoundException(String message){
        super(message);
    }
}
