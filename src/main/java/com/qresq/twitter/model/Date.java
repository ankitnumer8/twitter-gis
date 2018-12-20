package com.qresq.twitter.model;

import com.qresq.twitter.dto.CommonDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Class Date.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Date extends CommonDTO {

	/** The mm. */
	private int mm;

	/** The dd. */
	private int dd;

	/** The yyyy. */
	private int yyyy;

}
