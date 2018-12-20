package com.qresq.twitter.service.response;

import org.springframework.http.HttpStatus;

public class ResponseBuilder {

    /**
     * Builds the ok response.
     *
     * @param statusCode the status code
     * @param statusMsg the status msg
     * @param wrappedObj the wrapped obj
     * @return the response
     */
    public static <T> Response<T> buildOkResponse(T wrappedObj, HttpStatus statusCode, String statusMsg) {
        return new Response<T>(wrappedObj, statusCode, statusMsg);
    }

    /**
     * Builds the error response.
     *
     * @param statusCode the status code
     * @param statusMsg the status msg
     * @return the response
     */
    public static <T> Response<T> buildErrorResponse(HttpStatus statusCode, String statusMsg) {
        return new Response<T>(statusCode, statusMsg);
    }

}
