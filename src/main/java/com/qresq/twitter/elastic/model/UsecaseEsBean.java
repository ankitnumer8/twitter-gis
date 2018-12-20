/**
 * 
 */
package com.qresq.twitter.elastic.model;

import com.qresq.twitter.elastic.core.EsBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Class ResearchPaper.
 *
 * @author ankit.gupta
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class UsecaseEsBean extends EsBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant EVENT_INDEX. */
	public static final String USECASE_INDEX = "usecase_index";

	/** The Constant EVENT_DOCTYPE. */
	public static final String USECASE_DOC_TYPE = "usecase_index";
	
	/** The arxiv id. */
	private String category;

	/** The doi. */
	private String uid;

	/** The title. */
	private String title;

	/** The h index. */
	private String image;
	
	/** The description. */
	private String description;

}
