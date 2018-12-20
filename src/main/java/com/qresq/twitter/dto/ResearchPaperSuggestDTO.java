package com.qresq.twitter.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class ResearchPaperSuggestDTO extends CommonDTO {

	/** The arxiv id. */
	private String arxivId;

	/** The title. */
	private String title;

	/** The url. */
	private String url;

	/** The subjects. */
	private Object subjects;

	/** The authors. */
	private Object authors;

	/** The matched with. */
	private String matchedWith;

	/** The tags. */
	private Object tags;

	/** The description. */
	private String description;
	
	/** The venue. */
	private String venue;
	
	/** The citations. */
	private Object citations;
	
	/** The influential citations. */
	private Object influentialCitations;
}
