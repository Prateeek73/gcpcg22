package com.trainingapps.schoolms.studentms.controller;

import com.trainingapps.schoolms.studentms.exceptions.InvalidStudentAgeException;
import com.trainingapps.schoolms.studentms.exceptions.InvalidStudentIdException;
import com.trainingapps.schoolms.studentms.exceptions.InvalidStudentNameException;
import com.trainingapps.schoolms.studentms.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@Component
@RestControllerAdvice
public class CentralizedExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(StudentNotFoundException.class)
    public String handleStudentNotFound(StudentNotFoundException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            InvalidStudentAgeException.class,
            InvalidStudentIdException.class,
            InvalidStudentNameException.class,
            MethodArgumentNotValidException.class,
            ConstraintViolationException.class
    })
    public String handleInvalid(Exception e){
        return e.getMessage();
    }


}
