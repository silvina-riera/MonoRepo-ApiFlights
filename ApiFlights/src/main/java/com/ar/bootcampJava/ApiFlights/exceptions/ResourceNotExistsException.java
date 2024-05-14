package com.ar.bootcampJava.ApiFlights.exceptions;

public class ResourceNotExistsException extends RuntimeException{

    public ResourceNotExistsException(String message){
        super(message);
    }
}
