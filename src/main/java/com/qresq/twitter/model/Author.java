package com.qresq.twitter.model;

import com.qresq.twitter.dto.CommonDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Instantiates a new author.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Author extends CommonDTO{

	/** The name. */
	private String name;
	
	/** The auth id. */
	private Long authId;
	
	private String image;
}
