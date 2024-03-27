package com.hexaware.exception;

/**
 * UserNotFoundException
 *
 * This exception is thrown when a user with the specified ID is not found in
 * the system. It extends the built-in `Exception` class.
 */
public class UserNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor to create a UserNotFoundException with a custom message.
	 *
	 * @param message The message describing the reason why the exception is thrown.
	 */
	public UserNotFoundException(String message) {
		super(message);
	}
}