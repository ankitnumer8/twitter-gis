package com.qresq.twitter.service;

import java.util.List;

import com.qresq.twitter.exception.ServiceException;
import com.qresq.twitter.model.Event;

/**
 * The Interface HotelService.
 */
public interface EventService {

	/**
	 * Save events.
	 *
	 * @param eventFile
	 *            the event file
	 * @return true, if successful
	 * @throws ServiceException
	 *             the service exception
	 */
	boolean saveEvents(String eventFile) throws ServiceException;

	/**
	 * Search event by geo point.
	 *
	 * @param geoPoint
	 *            the geo point
	 * @param distance
	 *            the distance
	 * @return the list
	 */
	public List<Event> searchEventByGeoPoint(final String geoPoint, final String distance) throws ServiceException;

	/**
	 * Search event in city.
	 *
	 * @param cityName
	 *            the city name
	 * @return the list
	 */
	public List<Event> searchEventInCity(final String cityName) throws ServiceException;
}
