package com.ar.bootcampJava.ApiMilesProgram.exceptions;

public class ResourceNotExistsException extends RuntimeException{

    public ResourceNotExistsException(String message){
        super(message);
    }
}
