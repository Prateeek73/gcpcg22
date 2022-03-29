package com.example.jobms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.jobms.exceptions.DescriptionOutOfBoundsException;
import com.example.jobms.exceptions.IdNotFoundException;
import com.example.jobms.exceptions.InvalidJobTypeException;

import javax.validation.ConstraintViolationException;

@Component
@RestControllerAdvice
public class CentralizedExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(IdNotFoundException.class)
	public String idNotFoundException(IdNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ DescriptionOutOfBoundsException.class, InvalidJobTypeException.class,
			MethodArgumentNotValidException.class, ConstraintViolationException.class })
	public String descriptionOutOfBoundsRequest(Exception e) {
		return e.getMessage();
	}
}
