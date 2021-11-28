package com.solucionesverdes.postbems.exceptions;

public class CiudadNotFoundException extends RuntimeException {
    public  CiudadNotFoundException(String message){
        super(message);
    }
}
