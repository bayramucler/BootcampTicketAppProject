package com.bootcampprojects.ticketapp.controller.advice;

import com.bootcampprojects.ticketapp.exception.*;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handle(UserNotFoundException exception) {
		return ResponseEntity.ok(new ExceptionResponse(exception.getMessage(), HttpStatus.NOT_FOUND));
	}

	@ExceptionHandler(TicketAppException.class)
	public ResponseEntity<ExceptionResponse> handle(TicketAppException exception) {
		String message = messageSource.getMessage(exception.getKey(), null, new Locale("tr"));	
		return ResponseEntity.ok(new ExceptionResponse(message, HttpStatus.BAD_REQUEST));
	}

	@ExceptionHandler(TripNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handle(TripNotFoundException exception) {
		return ResponseEntity.ok(new ExceptionResponse(exception.getMessage(), HttpStatus.NOT_FOUND));
	}

	@ExceptionHandler(IndividualTicketLimitException.class)
	public ResponseEntity<ExceptionResponse> handle(IndividualTicketLimitException exception) {
		return ResponseEntity.ok(new ExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST));
	}

	@ExceptionHandler(CorpareteTicketLimitException.class)
	public ResponseEntity<ExceptionResponse> handle(CorpareteTicketLimitException exception) {
		return ResponseEntity.ok(new ExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST));
	}

	@ExceptionHandler(AvailableSeatNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handle(AvailableSeatNotFoundException exception) {
		return ResponseEntity.ok(new ExceptionResponse(exception.getMessage(), HttpStatus.NOT_FOUND));
	}

	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<ExceptionResponse> handle(AuthorizationException exception) {
		return ResponseEntity.ok(new ExceptionResponse(exception.getMessage(), HttpStatus.UNAUTHORIZED));
	}

/*
	@ResponseBody
	@ExceptionHandler(PSQLException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	String UniqueConstraintException(PSQLException exception) {
		var errorCode = exception.getSQLState();
		if(errorCode.equals("23505")) {
			return USER_ALREADY_IN_THE_SYSTEM;
		}
		return exception.getMessage();
	}

	@ResponseBody
	@ExceptionHandler(TripNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String voyageNotFoundHandler(TripNotFoundException exception) {
		return exception.getMessage();
	}


	@ResponseBody
	@ExceptionHandler(NotEnoughAvailableSeatsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String NotEnoughAvailableSeatsException(NotEnoughAvailableSeatsException exception) {
		return exception.getMessage();
	}

 */
}
