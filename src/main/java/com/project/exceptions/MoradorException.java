package com.project.exceptions;

public class MoradorException extends RuntimeException {
    public MoradorException(String message){
        super(message);
    }

    public MoradorException(String message, Throwable cause){
        super(message, cause);
    }
}
