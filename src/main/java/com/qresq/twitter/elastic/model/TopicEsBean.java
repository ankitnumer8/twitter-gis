/**
 * 
 */
package com.qresq.twitter.elastic.model;

import java.util.List;

import com.qresq.twitter.elastic.core.EsBean;
import com.qresq.twitter.model.Author;
import com.qresq.twitter.model.TagDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Class ResearchPaper.
 *
 * @author ankit.gupta
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class TopicEsBean extends EsBean {

	private static final long serialVersionUID = 1L;
	
	/** The Constant EVENT_INDEX. */
	public static final String TOPIC_INDEX = "topic_index";

	/** The Constant EVENT_DOCTYPE. */
	public static final String TOPIC_DOC_TYPE = "topic_index";

	/** The arxiv id. */
	private String name;

	/** The doi. */
	private String image;

	/** The description. */
	private String id;
	
	/** The title. */
	private String title;
	
	/** The url. */
	private String url;
	
	/** The dateline. */
	private String dateline;
	
	/** The journal reference. */
	private String journalReference;
	
	/** The submission history. */
	private String submissionHistory;
	
	/** The comments. */
	private String comments;
	
	/** The yyyy. */
	private String yyyy;
	
	/** The mm. */
	private String mm;
	
	/** The subjects. */
	private List<String> subjects;
	
	/** The dd. */
	private String dd;

	/** The report number. */
	private String reportNumber;
	
	/** The authors. */
	private List<Author> authors;
	
	/** The pdf. */
	private String pdf;

	/** The archive year. */
	private String archiveYear;
	
	/** The tags. */
	private List<TagDetails> tags;
	
	/** The influential citations. */
	private Integer influentialCitations;
	
	/** The citations. */
	private Integer citations;

	/** The research id. */
	private String researchId;


}
