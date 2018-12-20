package com.qresq.twitter.dao;

import java.util.List;

import com.qresq.twitter.exception.DAOException;
import com.qresq.twitter.model.Event;

public interface EsEventDAO {

	/**
	 * Inject events.
	 *
	 * @param eventList
	 *            the event list
	 * @return true, if successful
	 * @throws DAOException
	 *             the DAO exception
	 */
	boolean injectEvents(List<Event> eventList) throws DAOException;

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
	public List<Event> searchEventByGeoPoint(final String geoPoint, final String distance) throws DAOException;

}
