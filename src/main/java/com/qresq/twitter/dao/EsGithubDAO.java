package com.qresq.twitter.dao;

import java.util.List;

import org.elasticsearch.action.search.SearchResponse;

import com.qresq.twitter.dto.PdfDTO;
import com.qresq.twitter.elastic.model.GitRepoEsBean;
import com.qresq.twitter.elastic.model.GithubEsBean;
import com.qresq.twitter.exception.DAOException;

/**
 * The Interface EsGithubDAO.
 */
public interface EsGithubDAO {

	/**
	 * Inject github data.
	 *
	 * @param githubList
	 *            the github list
	 * @return true, if successful
	 * @throws DAOException
	 *             the DAO exception
	 */
	boolean injectGithubData(List<GithubEsBean> githubList) throws DAOException;

	/**
	 * Inject git repo data.
	 *
	 * @param gitRepoList
	 *            the git repo list
	 * @return true, if successful
	 * @throws DAOException
	 *             the DAO exception
	 */
	boolean injectGitRepoData(List<GitRepoEsBean> gitRepoList) throws DAOException;

	/**
	 * Search by release paper.
	 *
	 * @param arxId
	 *            the arx id
	 * @return the list
	 * @throws DAOException
	 *             the DAO exception
	 */
	public SearchResponse searchByReleasePaper(final String arxId) throws DAOException;

	/**
	 * Search by readme content.
	 *
	 * @param readmeContent
	 *            the readme content
	 * @return the search response
	 * @throws DAOException
	 *             the DAO exception
	 */
	public SearchResponse searchByReadmeContent(final String readmeContent) throws DAOException;

	/**
	 * Search by readme content.
	 *
	 * @param paper
	 *            the paper
	 * @return the search response
	 * @throws DAOException
	 *             the DAO exception
	 */
	public SearchResponse searchByReleasePaper(final PdfDTO paper) throws DAOException;

}
