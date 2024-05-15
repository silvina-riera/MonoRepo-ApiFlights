package com.ar.bootcampJava.ApiAirportManager.exceptions;

public class ResourceNotExistsException extends RuntimeException{

    public ResourceNotExistsException(String message){
        super(message);
    }
}
