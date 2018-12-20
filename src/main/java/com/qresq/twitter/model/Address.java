package com.qresq.twitter.model;

import com.qresq.twitter.dto.CommonDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Class Address.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Address extends CommonDTO{

	/** The postal code. */
	private  String postalCode;
	
	/** The city. */
	private String city;
	
	/** The street address. */
	private String streetAddress;
	
	/** The country. */
	private String country;

}
