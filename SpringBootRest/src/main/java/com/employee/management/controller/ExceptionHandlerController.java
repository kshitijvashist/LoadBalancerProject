package com.employee.management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.employee.management.exception.EmployeeNotExistExcpetion;

@ControllerAdvice
@Component
public class ExceptionHandlerController {

	@ExceptionHandler(value = EmployeeNotExistExcpetion.class)
	public ResponseEntity<Object> exception(EmployeeNotExistExcpetion exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);


		}
	}
