package com.qresq.twitter.dao;

import java.util.List;

import com.qresq.twitter.elastic.model.GpuEsBean;
import com.qresq.twitter.elastic.model.MeetupEsBean;
import com.qresq.twitter.elastic.model.UsecaseEsBean;
import com.qresq.twitter.exception.DAOException;
import com.qresq.twitter.model.Event;

public interface EsMeetupDAO {

	/**
	 * Inject data.
	 *
	 * @param usecasList
	 *            the usecas list
	 * @return true, if successful
	 * @throws DAOException
	 *             the DAO exception
	 */
	boolean injectData(List<MeetupEsBean> usecasList) throws DAOException;

	/**
	 * Search by id.
	 *
	 * @param usercaseIdList
	 *            the usercase id list
	 * @return the list
	 * @throws DAOException
	 *             the DAO exception
	 */
	public List<MeetupEsBean> searchByTag(List<String> tagids) throws DAOException;
	
	/**
	 * Search event by geo point.
	 *
	 * @param geoPoint
	 *            the geo point
	 * @param distance
	 *            the distance
	 * @return the list
	 * @throws Exception
	 *             the exception
	 */
	public List<MeetupEsBean> searchEventByGeoPoint(final String geoPoint, final String distance) throws DAOException;

	/**
	 * Search by company.
	 *
	 * @param companyList
	 *            the company list
	 * @return the list
	 * @throws DAOException
	 *             the DAO exception
	 */
	public List<MeetupEsBean> searchByText(String text) throws DAOException;
}
