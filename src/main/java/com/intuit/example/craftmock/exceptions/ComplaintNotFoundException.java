package com.intuit.example.craftmock.exceptions;

public class ComplaintNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 9137592579168775542L;

	public ComplaintNotFoundException(String id) {

        super(String.format("Complaint with Id %d not found", id));
    }
}
