package com.qresq.twitter.model;

import com.qresq.twitter.dto.CommonDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Instantiates a new performer.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Performer extends CommonDTO{

	/** The name. */
	private String name;
	
	/** The type. */
	private String type;
	
}
