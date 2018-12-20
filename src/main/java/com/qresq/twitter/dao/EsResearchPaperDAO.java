package com.qresq.twitter.dao;

import java.util.List;

import org.elasticsearch.action.search.SearchResponse;

import com.qresq.twitter.dto.ResearchPaperMetaDTO;
import com.qresq.twitter.elastic.model.ResearchPaperEsBean;
import com.qresq.twitter.exception.DAOException;

public interface EsResearchPaperDAO {

	/**
	 * Inject published paper.
	 *
	 * @param publishedPaper
	 *            the published paper
	 * @return true, if successful
	 * @throws DAOException
	 *             the DAO exception
	 */
	boolean injectPublishedPaper(List<ResearchPaperEsBean> publishedPaper) throws DAOException;

	/**
	 * Published paper suggest.
	 *
	 * @param text
	 *            the text
	 * @return the list
	 * @throws DAOException
	 *             the DAO exception
	 */
	public List<ResearchPaperEsBean> publishedPaperSuggest(final String text) throws DAOException;

	/**
	 * Suggest.
	 *
	 * @param suggestName
	 *            the suggest name
	 * @param text
	 *            the text
	 * @return the search response
	 * @throws DAOException
	 *             the DAO exception
	 */
	public SearchResponse suggest(String suggestName, String text) throws DAOException;

	/**
	 * Similar paper.
	 *
	 * @param docMeta
	 *            the doc meta
	 * @return the search response
	 * @throws DAOException
	 *             the DAO exception
	 */
	public SearchResponse similarPaper(String docMeta) throws DAOException;

	/**
	 * Paper by id.
	 *
	 * @param docId
	 *            the doc id
	 * @return the research paper
	 * @throws DAOException
	 *             the DAO exception
	 */
	public ResearchPaperEsBean paperById(String docId) throws DAOException;

	/**
	 * Search by topic.
	 *
	 * @param tagIds
	 *            the tag ids
	 * @return the search response
	 * @throws DAOException
	 *             the DAO exception
	 */
	public List<ResearchPaperMetaDTO> searchByTopic(List<String> tagIds) throws DAOException;

	/**
	 * Search by author.
	 *
	 * @param authorIds
	 *            the author ids
	 * @return the search response
	 * @throws DAOException
	 *             the DAO exception
	 */
	public List<ResearchPaperMetaDTO> searchByAuthor(List<String> authorIds) throws DAOException;
	
	/**
	 * Search by author.
	 *
	 * @param authorIds
	 *            the author ids
	 * @return the search response
	 * @throws DAOException
	 *             the DAO exception
	 */
	public List<ResearchPaperEsBean> topResearchPaper() throws DAOException;

}
