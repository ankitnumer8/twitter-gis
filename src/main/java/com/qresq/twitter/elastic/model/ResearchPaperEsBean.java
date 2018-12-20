/**
 * 
 */
package com.qresq.twitter.elastic.model;

import java.util.ArrayList;
import java.util.List;

import com.qresq.twitter.dto.GitRepoDTO;
import com.qresq.twitter.elastic.core.EsBean;
import com.qresq.twitter.model.Author;
import com.qresq.twitter.model.SuggestBean;
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
public class ResearchPaperEsBean extends EsBean {

	private static final long serialVersionUID = 1L;
	
	/** The Constant EVENT_INDEX. */
	public static final String RESEARCH_INDEX = "research_paper_index";

	/** The Constant EVENT_DOCTYPE. */
	public static final String RESEARCH_DOC_TYPE = "research_paper_index";

	/** The arxiv id. */
	private String arxivId;

	/** The doi. */
	private String doi;

	/** The description. */
	private String description;
	
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
	private int influentialCitations;
	
	/** The citations. */
	private int citations;

	/** The research id. */
	private String researchId;
	
	/** The venue. */
	private String venue;
	
	/** The suggest text. */
	private List<SuggestBean> suggestText;
	
	/** The git repos. */
	private List<GitRepoDTO> gitRepos;
	
	/**
	 * Sets the suggest.
	 */
	public void setSuggest(){
		List<SuggestBean> suggestText = new ArrayList<>();
		suggestText.add(new SuggestBean(arxivId, 3));
		suggestText.add(new SuggestBean(title, 2));
//		suggestText.add(new SuggestBean(authors, 1));
		this.suggestText = suggestText;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
        return arxivId;
    }

}
