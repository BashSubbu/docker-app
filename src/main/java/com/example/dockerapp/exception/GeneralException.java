package com.example.dockerapp.exception;

// extends run time exception
public class GeneralException extends RuntimeException{
    public GeneralException(String exception){
        super(exception);
    }
}
