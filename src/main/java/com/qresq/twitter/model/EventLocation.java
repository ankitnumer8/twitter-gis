package com.qresq.twitter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qresq.twitter.dto.CommonDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The Class Location.
 */

/**
 * Instantiates a new event location.
 */
@EqualsAndHashCode(callSuper = false)
@Data
public final class EventLocation extends CommonDTO {

	/** The city. */
	private String city;
	
	/** The street address. */
	@JsonProperty("streetAddress")
	private String streetAddress;
	
	/** The name. */
	private String name;
	
	/** The full address. */
	private String fullAddress;
	
	/** The country. */
	private String country;

}
