package com.qresq.twitter.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qresq.twitter.dao.EsEventDAO;
import com.qresq.twitter.exception.DAOException;
import com.qresq.twitter.exception.ServiceException;
import com.qresq.twitter.model.Event;
import com.qresq.twitter.service.EventService;
import com.qresq.twitter.utils.EntityReader;

/**
 * The Class HotelUploadServiceImpl.
 */
@Service
public class EventServiceImpl implements EventService {

	/** The logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(EventServiceImpl.class);

	@Autowired
	private EsEventDAO eventDao;

	@Override
	public boolean saveEvents(String eventFile) throws ServiceException {
		try {
			List<Event> eventList = EntityReader.getInstance().readFile(eventFile, Event.class);
			eventDao.injectEvents(eventList);
			return true;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<Event> searchEventByGeoPoint(String geoPoint, String distance) throws ServiceException {
		try {
			return eventDao.searchEventByGeoPoint(geoPoint, distance);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<Event> searchEventInCity(String cityName) {
		return null;
	}


}
