package com.qresq.twitter.dao;

import java.util.List;

import com.qresq.twitter.elastic.model.GpuEsBean;
import com.qresq.twitter.exception.DAOException;

public interface EsGpuDAO {

	/**
	 * Inject events.
	 *
	 * @param authorList
	 *            the author list
	 * @return true, if successful
	 * @throws DAOException
	 *             the DAO exception
	 */
	boolean injectGpuData(List<GpuEsBean> gpuList) throws DAOException;

	/**
	 * Search by company.
	 *
	 * @param companyList
	 *            the company list
	 * @return the list
	 * @throws DAOException
	 *             the DAO exception
	 */
	public List<GpuEsBean> searchByCompany(List<String> companyList) throws DAOException;
	
	/**
	 * Search by company.
	 *
	 * @param companyList
	 *            the company list
	 * @return the list
	 * @throws DAOException
	 *             the DAO exception
	 */
	public List<GpuEsBean> searchByText(String text) throws DAOException;

}
