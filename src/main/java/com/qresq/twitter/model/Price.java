package com.qresq.twitter.model;

import com.qresq.twitter.dto.CommonDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Instantiates a new price.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Price extends CommonDTO{

	/** The currency. */
	private String currency;
	
	/** The price. */
	private String price;
	
	/** The vendor. */
	private String vendor;
	
}
