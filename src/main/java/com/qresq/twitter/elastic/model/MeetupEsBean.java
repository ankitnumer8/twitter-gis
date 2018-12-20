/**
 * 
 */
package com.qresq.twitter.elastic.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qresq.twitter.elastic.core.EsBean;
import com.qresq.twitter.model.GeoLocation;
import com.qresq.twitter.model.TagDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Class MeetupEsBean.
 *
 * @author ankit.gupta
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MeetupEsBean extends EsBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant EVENT_INDEX. */
	public static final String MEETUP_INDEX = "meetup_index";

	/** The Constant EVENT_DOCTYPE. */
	public static final String MEETUP_DOC_TYPE = "meetup_index";

	/** The start date. */
	private Object startDate;

	/** The end date. */
	private Object endDate;

	/** The event description. */
	private String eventDescription;

	/** The location. */
	@JsonProperty("eventLocation")
	private Object eventLocation;

	/** The arxiv id. */
	private String website;

	/** The doi. */
	private String ranking;

	/** The title. */
	private String title;

	/** The url. */
	private String eventUrl;

	@JsonProperty("hindex")
	private BigDecimal hIndex;

	/** The tags. */
	private List<TagDetails> tags;

	/** The publisher. */
	private String publisher;

	/** The location. */
	private String location;

	/** The lat. */
	private Double latitude;

	/** The lon. */
	private Double longitude;

	/** The twitter. */
	private String twitter;

	/** The linkedin. */
	private String linkedin;

	/** The event location. */
	private GeoLocation eventNewGeoLocation;

	/** The members. */
	private String members;

	/** The images. */
	private List<String> images;

	/** The event images. */
	private List<String> eventImages;

	/** The sponsor. */
	private List<String> sponsor;
	
	/** The facebook. */
	private String facebook;
}
