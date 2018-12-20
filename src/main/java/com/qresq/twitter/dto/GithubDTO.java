package com.qresq.twitter.dto;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Class PdfDTO.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GithubDTO extends CommonDTO {

	/** The repo name. */
	private String repo_name;
	
	/** The repo link. */
	private String repo_link;
	
	/** The commits count. */
	private String commits_count;
	
	/** The pull count. */
	private String pull_count;
	
	/** The developer name. */
	private String developer_name;
	
	/** The arxiv ids. */
	private List<String> arxivIds;

}
