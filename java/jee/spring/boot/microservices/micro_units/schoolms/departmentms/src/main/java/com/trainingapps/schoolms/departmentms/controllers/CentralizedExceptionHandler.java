package com.trainingapps.schoolms.departmentms.controllers;

import com.trainingapps.schoolms.DemoApplication;
import com.trainingapps.schoolms.departmentms.exceptions.DepartmentNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
//@ControllerAdvice
public class CentralizedExceptionHandler {
    private static final Logger Log= LoggerFactory.getLogger(CentralizedExceptionHandler.class);


   // @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<String> handleDepartmentNotFoundException(DepartmentNotFoundException e){
        Log.error("inside handleDepartmentNotFoundException",e);
        return new ResponseEntity<String>( e.getMessage(), HttpStatus.NOT_FOUND);

    }

}
