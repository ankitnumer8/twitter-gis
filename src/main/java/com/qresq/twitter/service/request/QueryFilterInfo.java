package com.qresq.twitter.service.request;

import com.qresq.twitter.dto.CommonDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Instantiates a new query filter info.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class QueryFilterInfo extends CommonDTO {

	/** The field name. */
	private String fieldName;

	/** The value. */
	private Object value;
}
