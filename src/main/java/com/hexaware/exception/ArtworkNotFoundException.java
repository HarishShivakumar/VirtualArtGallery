package com.hexaware.exception;

public class ArtworkNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	/**
     * Constructor to create an ArtworkNotFoundException with a custom message.
     *
     * @param message The message describing the reason why the exception is thrown.
     */
	public ArtworkNotFoundException(String message){
        super(message);
    }
}
