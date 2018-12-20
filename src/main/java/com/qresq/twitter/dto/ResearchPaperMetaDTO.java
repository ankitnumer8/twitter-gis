package com.qresq.twitter.dto;

import java.util.List;

import com.qresq.twitter.model.Author;
import com.qresq.twitter.model.TagDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class ResearchPaperMetaDTO extends CommonDTO {

	/** The arxiv id. */
	private String arxivId;

	/** The title. */
	private String title;

	/** The url. */
	private String url;

	/** The subjects. */
	private List<String> subjects;

	/** The authors. */
	private List<Author> authors;

	/** The matched with. */
	private String matchedWith;
	
	/** The pdf. */
	private String pdf;

	/** The tags. */
	private List<TagDetails> tags;

	/** The description. */
	private String description;
	
	private String venue;
	
	/** The citations. */
	private Integer citations;
	
	/** The influential citations. */
	private Integer influentialCitations;
	
	/** The git repos. */
	private List<GitRepoDTO> gitRepos;
}
