package com.qresq.twitter.model;

import com.qresq.twitter.dto.CommonDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Class Address.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NormalPricing extends CommonDTO{

	/** The postal code. */
	private  String timing;
	
	/** The city. */
	private String currency;
	
	/** The street address. */
	private double rate;

}
