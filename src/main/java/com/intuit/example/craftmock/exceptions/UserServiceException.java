package com.intuit.example.craftmock.exceptions;

public class UserServiceException extends RuntimeException {

	private static final long serialVersionUID = 4416309658812132198L;
	
	public UserServiceException(String message) {
		super(message);
	}
}
	
