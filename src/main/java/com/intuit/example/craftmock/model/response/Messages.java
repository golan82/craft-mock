package com.intuit.example.craftmock.model.response;

public enum Messages {
	
	MESSAGE_SUCCESS("Your complaint has been received."
			+ " We will update for further treatment in the near future");
	
	private String message;
	
	private Messages (String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
