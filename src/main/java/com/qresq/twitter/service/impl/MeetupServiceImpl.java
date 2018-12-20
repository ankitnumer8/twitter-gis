package com.qresq.twitter.service.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qresq.twitter.dao.EsMeetupDAO;
import com.qresq.twitter.elastic.model.MeetupEsBean;
import com.qresq.twitter.exception.DAOException;
import com.qresq.twitter.exception.ServiceException;
import com.qresq.twitter.model.GeoLocation;
import com.qresq.twitter.service.MeetupService;
import com.qresq.twitter.utils.EntityReader;

/**
 * The Class HotelUploadServiceImpl.
 */
@Service
public class MeetupServiceImpl implements MeetupService {

	/** The logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(MeetupServiceImpl.class);

	@Autowired
	private EsMeetupDAO meetupDAO;

	@Override
	public boolean saveData(String gpuFile) throws ServiceException {
		try {
			List<MeetupEsBean> meetUpList = EntityReader.getInstance().readFile(gpuFile, MeetupEsBean.class);
			processMeetupList(meetUpList);
			meetupDAO.injectData(meetUpList);
			return true;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Process meetup list.
	 *
	 * @param meetUpList
	 *            the meet up list
	 */
	private void processMeetupList(List<MeetupEsBean> meetUpList) {
		if (CollectionUtils.isNotEmpty(meetUpList)) {
			for (MeetupEsBean meetUpBean : meetUpList) {
				GeoLocation geoLocation = new GeoLocation(meetUpBean.getLatitude(), meetUpBean.getLongitude());
				meetUpBean.setEventNewGeoLocation(geoLocation);
			}
		}
	}

	@Override
	public List<MeetupEsBean> searchByTags(List<String> tagIds) throws ServiceException {
		try {
			return meetupDAO.searchByTag(tagIds);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<MeetupEsBean> searchEventByGeoPoint(String geoPoint, String distance) throws ServiceException {
		try {
			return meetupDAO.searchEventByGeoPoint(geoPoint, distance);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<MeetupEsBean> searchByText(String text) throws ServiceException {
		try {
			return meetupDAO.searchByText(text);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
