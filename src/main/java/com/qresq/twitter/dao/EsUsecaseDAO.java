package com.qresq.twitter.dao;

import java.util.List;

import com.qresq.twitter.elastic.model.UsecaseEsBean;
import com.qresq.twitter.exception.DAOException;

public interface EsUsecaseDAO {

	/**
	 * Inject data.
	 *
	 * @param usecasList
	 *            the usecas list
	 * @return true, if successful
	 * @throws DAOException
	 *             the DAO exception
	 */
	boolean injectData(List<UsecaseEsBean> usecasList) throws DAOException;

	/**
	 * Search by company.
	 *
	 * @param companyList
	 *            the company list
	 * @return the list
	 * @throws DAOException
	 *             the DAO exception
	 */
	public List<UsecaseEsBean> searchByCategory(List<String> categoryList) throws DAOException;

	/**
	 * Search by id.
	 *
	 * @param usercaseIdList
	 *            the usercase id list
	 * @return the list
	 * @throws DAOException
	 *             the DAO exception
	 */
	public List<UsecaseEsBean> searchById(List<String> usercaseIdList) throws DAOException;
	
	/**
	 * Search by id.
	 *
	 * @param usercaseIdList
	 *            the usercase id list
	 * @return the list
	 * @throws DAOException
	 *             the DAO exception
	 */
	public List<UsecaseEsBean> searchByText(String text) throws DAOException;

}
