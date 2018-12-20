package com.qresq.twitter.service;

import java.util.List;

import com.qresq.twitter.elastic.model.GpuEsBean;
import com.qresq.twitter.elastic.model.MeetupEsBean;
import com.qresq.twitter.elastic.model.UsecaseEsBean;
import com.qresq.twitter.exception.ServiceException;
import com.qresq.twitter.model.Event;

/**
 * The Interface AuthorService.
 */
public interface MeetupService {

	/**
	 * Save events.
	 *
	 * @param authorFile
	 *            the author file
	 * @return true, if successful
	 * @throws ServiceException
	 *             the service exception
	 */
	boolean saveData(String gpuFile) throws ServiceException;

	/**
	 * Search by company.
	 *
	 * @param company
	 *            the company
	 * @return the list
	 * @throws ServiceException
	 *             the service exception
	 */
	public List<MeetupEsBean> searchByTags(final List<String> category) throws ServiceException;

	/**
	 * Search event by geo point.
	 *
	 * @param geoPoint
	 *            the geo point
	 * @param distance
	 *            the distance
	 * @return the list
	 */
	public List<MeetupEsBean> searchEventByGeoPoint(final String geoPoint, final String distance)
			throws ServiceException;

	/**
	 * Search by company.
	 *
	 * @param company
	 *            the company
	 * @return the list
	 * @throws ServiceException
	 *             the service exception
	 */
	public List<MeetupEsBean> searchByText(final String text) throws ServiceException;
}
