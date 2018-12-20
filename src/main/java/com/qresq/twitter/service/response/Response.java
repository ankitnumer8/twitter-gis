package com.qresq.twitter.service.response;

import org.springframework.http.HttpStatus;

import lombok.NoArgsConstructor;

/**
 * The Class Response.
 *
 * @param <T> the generic type
 */
@NoArgsConstructor
public class Response<T> {

    /** The results. */
    private T results;

    /** The http status. */
    private HttpStatus httpStatus;

    /** The message. */
    private String message;

    /**
     * Instantiates a new response.
     *
     * @param results the results
     * @param httpStatus the http status
     * @param message the message
     */
    public Response(T results, HttpStatus httpStatus, String message) {
        this.results = results;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    /**
     * Instantiates a new response.
     *
     * @param httpStatus the http status
     * @param message the message
     */
    public Response(HttpStatus httpStatus, String message) {
        super();
        this.httpStatus = httpStatus;
        this.message = message;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message the new message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the http status.
     *
     * @return the http status
     */
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    /**
     * Sets the http status.
     *
     * @param httpStatus the new http status
     */
    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    /**
     * Gets the results.
     *
     * @return the results
     */
    public T getResults() {
        return results;
    }

    /**
     * Sets the results.
     *
     * @param results the new results
     */
    public void setResults(T results) {
        this.results = results;
    }
}
