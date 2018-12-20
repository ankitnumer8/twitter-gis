package com.qresq.twitter.model;

import com.qresq.twitter.dto.CommonDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Instantiates a new author.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TagDetails extends CommonDTO{

	/** The name. */
	private String tag;
	
	/** The auth id. */
	private String tagId;
}
