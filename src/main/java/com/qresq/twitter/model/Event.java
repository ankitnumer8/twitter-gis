package com.qresq.twitter.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qresq.twitter.dto.CommonDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Instantiates a new event.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Event extends CommonDTO {

	/** The venue capacity. */
	private Date startDate;

	/** The full address. */
	private Date endDate;

	/** The venue url. */
	private String description;

	/** The doc type. */
	private String title;

	/** The concert date. */
	private String url;

	/** The lat. */
	private Double latitude;

	/** The lon. */
	private Double longitude;

	/** The event location. */
	private GeoLocation point;

	/** The location. */
	private EventLocation location;

	@JsonProperty("images")
	private List<String> images;

	/** The logo. */
	private String logo;

}
