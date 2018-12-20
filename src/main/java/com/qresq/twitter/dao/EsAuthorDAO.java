package com.qresq.twitter.dao;

import java.util.List;

import com.qresq.twitter.elastic.model.AuthorEsBean;
import com.qresq.twitter.exception.DAOException;

public interface EsAuthorDAO {

	/**
	 * Inject events.
	 *
	 * @param authorList
	 *            the author list
	 * @return true, if successful
	 * @throws DAOException
	 *             the DAO exception
	 */
	boolean injectAuthorData(List<AuthorEsBean> authorList) throws DAOException;

	/**
	 * Search event by geo point.
	 *
	 * @param authorIds
	 *            the author ids
	 * @return the list
	 * @throws DAOException
	 *             the DAO exception
	 */
	public List<AuthorEsBean> searchById(List<Long> authorIds) throws DAOException;
	
	/**
	 * Search event by geo point.
	 *
	 * @param authorIds
	 *            the author ids
	 * @return the list
	 * @throws DAOException
	 *             the DAO exception
	 */
	public List<AuthorEsBean> searchByText(String text) throws DAOException;
	
	/**
	 * Search event by geo point.
	 *
	 * @param authorIds
	 *            the author ids
	 * @return the list
	 * @throws DAOException
	 *             the DAO exception
	 */
	public List<AuthorEsBean> topAuthors() throws DAOException;


}
