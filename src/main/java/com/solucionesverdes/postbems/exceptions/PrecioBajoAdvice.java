package com.solucionesverdes.postbems.exceptions;
import  org.springframework.http.HttpStatus;
import  org.springframework.web.bind.annotation.ExceptionHandler;
import  org.springframework.web.bind.annotation.ControllerAdvice;
import  org.springframework.web.bind.annotation.ResponseBody;
import  org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody

public class PrecioBajoAdvice {
    @ResponseBody
    @ExceptionHandler(PrecioBajoException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String PrecioBajoAdvice(PrecioBajoException ex){
        return ex.getMessage();
    }
}
