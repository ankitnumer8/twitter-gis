package com.qresq.twitter.service;

import java.util.List;

import com.qresq.twitter.elastic.model.GpuEsBean;
import com.qresq.twitter.exception.ServiceException;

/**
 * The Interface AuthorService.
 */
public interface GpuService {

	/**
	 * Save events.
	 *
	 * @param authorFile
	 *            the author file
	 * @return true, if successful
	 * @throws ServiceException
	 *             the service exception
	 */
	boolean saveGpuData(String gpuFile) throws ServiceException;

	/**
	 * Search by company.
	 *
	 * @param company
	 *            the company
	 * @return the list
	 * @throws ServiceException
	 *             the service exception
	 */
	public List<GpuEsBean> searchByCompany(final List<String> company) throws ServiceException;
	
	/**
	 * Search by company.
	 *
	 * @param company
	 *            the company
	 * @return the list
	 * @throws ServiceException
	 *             the service exception
	 */
	public List<GpuEsBean> searchByText(final String text) throws ServiceException;

}
