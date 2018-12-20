package com.qresq.twitter.model;

import com.qresq.twitter.dto.CommonDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The Class Location.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public final class GeoLocation extends CommonDTO {

	/** The lat. */
	private Double lat;

	/** The lon. */
	private Double lon;

}
