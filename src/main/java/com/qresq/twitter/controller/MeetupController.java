package com.qresq.twitter.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.qresq.twitter.elastic.model.MeetupEsBean;
import com.qresq.twitter.service.MeetupService;
import com.qresq.twitter.service.response.Response;
import com.qresq.twitter.service.response.ResponseBuilder;

import io.swagger.annotations.ApiOperation;

/**
 * The Class HotelUploadController.
 */
@RestController
@RequestMapping(MeetupController.API_MEETUP_URL)
public class MeetupController {

	/** The logger. */
	private static final Logger logger = LoggerFactory.getLogger(MeetupController.class);

	/** The Constant API_READ_URL. */
	public static final String API_MEETUP_URL = "/api/meetup";

	/** The event service. */
	@Autowired
	private MeetupService meetupService;

	@ApiOperation(value = "saveMeetupData", notes = "saveMeetupData save Data")
	@RequestMapping(value = "/saveMeetupData", method = RequestMethod.POST)
	public ResponseEntity<?> saveMeetupData(@RequestParam("file") String fileName) {
		try {
			meetupService.saveData(fileName);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@ApiOperation(value = "Get Event by Topic", notes = "Get Event by Topic")
	@RequestMapping(value = "/getByTopic", method = RequestMethod.GET)
	public Response<List<MeetupEsBean>> getByTopic(@RequestParam(value = "topic") String topicId) {
		Response<List<MeetupEsBean>> response = null;
		try {
			List<MeetupEsBean> suggestDto = meetupService.searchByTags(Lists.newArrayList(topicId));
			response = ResponseBuilder.buildOkResponse(suggestDto, HttpStatus.OK, "");
		} catch (Exception e) {
			return ResponseBuilder.buildErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		return response;
	}

	/**
	 * Gets the nearest event.
	 *
	 * @param geoPoint
	 *            the geo point
	 * @param distance
	 *            the distance
	 * @return the nearest event
	 */
	@ApiOperation(value = "Get nearest event", notes = "Get nearest event")
	@RequestMapping(value = "/getNearestEvent", method = RequestMethod.GET)
	public Response<?> getNearestEvent(@RequestParam(value = "geoPoint") String geoPoint,
			@RequestParam(value = "distance", required = false) String distance) {
		Response<?> response = null;
		try {
			if (StringUtils.isEmpty(distance)) {
				distance = "2000";
			}
			List<MeetupEsBean> meetupEventList = meetupService.searchEventByGeoPoint(geoPoint, distance);
			response = ResponseBuilder.buildOkResponse(meetupEventList, HttpStatus.OK, "");
		} catch (Exception e) {
			return ResponseBuilder.buildErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		return response;
	}

	/**
	 * Search query time.
	 *
	 * @param hotelText
	 *            the hotel text
	 * @return the response entity
	 */
	@ApiOperation(value = "Search Meetup", notes = "Search Meetup")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public Response<?> search(@RequestParam(value = "text", required = false) String searchText) {
		Response<?> response = null;
		try {
			List<MeetupEsBean> gpusList = meetupService.searchByText(searchText);
			response = ResponseBuilder.buildOkResponse(gpusList, HttpStatus.OK, "");
		} catch (Exception e) {
			return ResponseBuilder.buildErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		return response;
	}

}
