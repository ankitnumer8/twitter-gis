package com.qresq.twitter.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class DAOException.
 */
public class ServiceException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new DAO exception.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new DAO exception.
	 *
	 * @param message
	 *            the message
	 */
	public ServiceException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new DAO exception.
	 *
	 * @param cause
	 *            the cause
	 */
	public ServiceException(Throwable cause) {
		super(cause);
	}

}
