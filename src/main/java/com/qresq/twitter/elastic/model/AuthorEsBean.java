/**
 * 
 */
package com.qresq.twitter.elastic.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qresq.twitter.elastic.core.EsBean;
import com.qresq.twitter.model.AuthorTagDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Class ResearchPaper.
 *
 * @author ankit.gupta
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AuthorEsBean extends EsBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant EVENT_INDEX. */
	public static final String AUTHOR_INDEX = "author_index";

	/** The Constant EVENT_DOCTYPE. */
	public static final String AUTHOR_DOC_TYPE = "author_index";
	
	/** The arxiv id. */
	private String name;

	/** The doi. */
	private String image;

	/** The tags. */
	private AuthorTagDetails tags;
	
	/** The description. */
	private Long authId;

	/** The title. */
	private String email;

	/** The influential citations. */
	private int influentialCitationCount;

	/** The citations. */
	private int citations;
	
	/** The h index. */
	@JsonProperty("hIndex")
	private BigDecimal hIndex;
	
	/** The twitter. */
	private List<String> twitter;
	
	/** The wikipedia. */
	private List<String> wikipedia;
	
	/** The homepage. */
	private List<String> homepage;
	
	/** The linkedin. */
	private List<String> linkedin;

}
