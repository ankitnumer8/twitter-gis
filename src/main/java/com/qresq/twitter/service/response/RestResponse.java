package com.qresq.twitter.service.response;

import org.springframework.http.HttpStatus;

import lombok.Data;

/**
 * The Class Response.
 *
 *            the generic type
 */
@Data
public abstract class RestResponse {

	/** The http status. */
	private HttpStatus httpStatus;

	/** The message. */
	private String message;

}
