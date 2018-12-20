/**
 * 
 */
package com.qresq.twitter.elastic.model;

import java.util.List;

import com.qresq.twitter.elastic.core.EsBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Class GithubEsBean.
 *
 * @author Ankit.Gupta
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GithubEsBean extends EsBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant EVENT_INDEX. */
	public static final String GITHUB_INDEX = "github_index";

	/** The Constant EVENT_DOCTYPE. */
	public static final String GITHUB_DOC_TYPE = "github_index";
	
	/** The developer bio. */
	private String developer_bio;

	/** The project count. */
	private String project_count;

	/** The contributor count. */
	private String contributor_count;

	/** The developer id. */
	private String developer_id;

	/** The readme text. */
	private String readme_text;

	/** The developer org. */
	private String developer_org;
	
	/** The star count. */
	private String star_count;
	
	/** The developer name. */
	private String developer_name;
	
	/** The developer photo. */
	private String developer_photo;
	
	/** The issue count. */
	private String issue_count;
	
	/** The repo name. */
	private String repo_name;
	
	/** The developer location. */
	private String developer_location;
	
	/** The release count. */
	private String release_count;
	
	/** The developer bio links. */
	private String developer_bio_links;
	
	/** The repo description. */
	private String repo_description;
	
	/** The branches count. */
	private String branches_count;
	
	/** The forked count. */
	private String forked_count;
	
	/** The number of watches. */
	private String number_of_watches;
	
	/** The repo tags. */
	private String repo_tags;
	
	/** The repo link. */
	private String repo_link;
	
	/** The commits count. */
	private String commits_count;
	
	/** The pull count. */
	private String pull_count;
	
	/** The arxiv ids. */
	private List<String> arxivIds;

}
