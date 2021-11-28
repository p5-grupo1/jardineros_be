package com.solucionesverdes.postbems.exceptions;
import  org.springframework.http.HttpStatus;
import  org.springframework.web.bind.annotation.ExceptionHandler;
import  org.springframework.web.bind.annotation.ControllerAdvice;
import  org.springframework.web.bind.annotation.ResponseBody;
import  org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody

public class AreaNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(AreaNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String EntityNotFoundAdvice(AreaNotFoundException ex) {
        return ex.getMessage();
    }
}
