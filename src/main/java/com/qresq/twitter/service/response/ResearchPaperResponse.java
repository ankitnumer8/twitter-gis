/**
 * 
 */
package com.qresq.twitter.service.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.qresq.twitter.dto.ResearchPaperSuggestDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Instantiates a new research paper response.
 * @author Ankit
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResearchPaperResponse extends RestResponse {

	/** The suggest list. */
	private List<ResearchPaperSuggestDTO> results;

	/** The pdf list. */
	private Object pdfList;

	/**
	 * Instantiates a new research paper response.
	 *
	 * @param statusCode
	 *            the status code
	 * @param statusMsg
	 *            the status msg
	 */
	public ResearchPaperResponse(HttpStatus statusCode, String statusMsg) {
		super.setHttpStatus(statusCode);
		super.setMessage(statusMsg);

	}

	/**
	 * Builds the error response.
	 *
	 * @param statusCode
	 *            the status code
	 * @param statusMsg
	 *            the status msg
	 * @return the research paper response
	 */
	public static ResearchPaperResponse buildErrorResponse(HttpStatus statusCode, String statusMsg) {
		return new ResearchPaperResponse(statusCode, statusMsg);
	}

}
