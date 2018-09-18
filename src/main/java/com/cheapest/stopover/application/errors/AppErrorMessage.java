package com.cheapest.stopover.application.errors;

public class AppErrorMessage extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorMessage;

	private AppErrorMessage() {
		// Need to create an object only with a message
	}

	public AppErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

}
