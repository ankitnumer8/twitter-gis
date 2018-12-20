package com.qresq.twitter.model;

import com.qresq.twitter.dto.CommonDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The Class Location.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public final class Location extends CommonDTO {

	/** The lat. */
	private Double lat;

	/** The lon. */
	private Double lon;

	/** The geo. */
	private GeoLocation geo;

	/**
	 * Instantiates a new location.
	 *
	 * @param lat
	 *            the lat
	 * @param lon
	 *            the lon
	 */
	public Location(Double lat, Double lon) {
		this.lat = lat;
		this.lon = lon;
	}

	/**
	 * Instantiates a new location.
	 *
	 * @param geo
	 *            the geo
	 */
	public Location(GeoLocation geo) {
		this.geo = geo;
	}

}
