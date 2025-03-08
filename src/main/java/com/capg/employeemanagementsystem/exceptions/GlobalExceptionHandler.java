package com.capg.employeemanagementsystem.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	
//	AdminNotFoundException
	
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleAdminNotFoundExeption(AdminNotFoundException ex, WebRequest request) {
		// creating exception response structure

		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}

//	ComplianceNotFoundException

	@ExceptionHandler(ComplianceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleRecordNotFoundExeption(ComplianceNotFoundException ex,
			WebRequest request) {
		// creating exception response structure

		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}

//	EmployeeRecordNotFoundException

	@ExceptionHandler(EmployeeRecordNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleRecordNotFoundExeption(EmployeeRecordNotFoundException ex,
			WebRequest request) {
		// creating exception response structure

		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}

	// DepartmentNotFoundException

	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleRecordNotFoundExeption(DepartmentNotFoundException ex,
			WebRequest request) {
		// creating exception response structure

		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}

	// StatusRecordNotFoundException

	@ExceptionHandler(StatusRecordNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleRecordNotFoundExeption(StatusRecordNotFoundException ex,
			WebRequest request) {
		// creating exception response structure

		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}

//ProjectNotFoundException

	@ExceptionHandler(ProjectNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleRecordNotFoundExeption(ProjectNotFoundException ex, WebRequest request) {
		// creating exception response structure

		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	

}
