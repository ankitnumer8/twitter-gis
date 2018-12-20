package com.qresq.twitter.dto;

import java.math.BigInteger;

import com.qresq.twitter.model.Location;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The Class CityDTO.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class CityDTO extends CommonDTO {

	/** The geoname id. */
	private long geonameId;

	/** The name. */
	private String name;

	/** The ascii name. */
	private String asciiName;

	/** The alternate names. */
	private String alternateNames;

	/** The lattitude. */
	private Location geoLocation;

	/** The country code. */
	private String countryCode;

	/** The state. */
	private String state;

	/** The country name. */
	private String countryName;

	/** The currency name. */
	private String currencyName;

	/** The currency code. */
	private String currencyCode;

	/** The admin 1 code. */
	private String admin1Code;

	/** The european. */
	private boolean european;

	/** The population. */
	private BigInteger population;

	/** The time zone. */
	private String timeZone;

	/** The time zone utc. */
	private String timeZoneUtc;

}
