package com.solucionesverdes.postbems.exceptions;
import  org.springframework.http.HttpStatus;
import  org.springframework.web.bind.annotation.ExceptionHandler;
import  org.springframework.web.bind.annotation.ControllerAdvice;
import  org.springframework.web.bind.annotation.ResponseBody;
import  org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody

public class PrecioNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(PrecioNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String EntityNotFoundAdvice(PrecioNotFoundException ex) {
        return ex.getMessage();
    }
}
