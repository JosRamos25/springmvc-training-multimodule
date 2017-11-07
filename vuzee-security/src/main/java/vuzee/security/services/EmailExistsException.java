package vuzee.security.services;

public class EmailExistsException extends Exception {



	/**
	 * 
	 */
	private static final long serialVersionUID = 3409741740955788429L;

	public EmailExistsException(String message) {
		super(message);
	}

}