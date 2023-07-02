package com.baproject.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestControllerAdvice
public class ApiExceptionHandler {
    Date date = new Date();
    SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    String timestamp = DateFor.format(date);


    @ExceptionHandler(value = ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), timestamp, "User not found", UUID.randomUUID().toString());
    }

//    @ExceptionHandler(value = ClassNotFoundException.class)
//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//    public ErrorMessage classNotFoundException(ClassNotFoundException ex) {
//        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), ex.getMessage(), "Class Not Found On The Classpath");
//    }
//
    @ExceptionHandler(value = InvocationTargetException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage invocationTargetException(InvocationTargetException ex) {
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), timestamp, "Internal Server Error", UUID.randomUUID().toString());
    }
}