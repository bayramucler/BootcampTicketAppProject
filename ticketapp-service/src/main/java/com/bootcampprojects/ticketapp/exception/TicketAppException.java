package com.bootcampprojects.ticketapp.exception;

public class TicketAppException extends RuntimeException {

	private String key;

	public TicketAppException(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

}
