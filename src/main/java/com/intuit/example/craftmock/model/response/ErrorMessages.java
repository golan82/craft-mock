package com.intuit.example.craftmock.model.response;

public enum ErrorMessages {
	
	MISSING_REQUIRED_FIELD("Missing required field. please check documentation for required fields"),
	RECORD_ALREADY_EXISTS("Record already exists"),
	INTERNAL_SERVER_ERROR("Internal server error"),
	NO_RECORD_FOUND("Record with provided id is not found"),
	COULD_NOT_UPDATE_RECORD("Could not update record"),
	COULD_NOT_DELETE_RECORD("Could not delete record");
	
	
	private String errorMessage;
	
	private ErrorMessages(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	/**
	 * 
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	
	/**
	 * 
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
