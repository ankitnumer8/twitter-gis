package com.qresq.twitter.controller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qresq.twitter.service.EventService;
import com.qresq.twitter.service.response.Response;
import com.qresq.twitter.service.response.ResponseBuilder;

import io.swagger.annotations.ApiOperation;

/**
 * The Class HotelUploadController.
 */
//@RestController
//@RequestMapping(EventController.API_EVENT_URL)
public class EventController {

	/** The logger. */
	private static final Logger logger = LoggerFactory.getLogger(EventController.class);

	/** The Constant API_READ_URL. */
	public static final String API_EVENT_URL = "/api/event";

	/** The event service. */
	@Autowired
	private EventService eventService;

	@ApiOperation(value = "Event", notes = "Inject Event Data")
	@RequestMapping(value = "/saveEvents", method = RequestMethod.POST)
	public ResponseEntity<?> ingestEventData(@RequestParam("file") String fileName) {
		try {
			eventService.saveEvents(fileName);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	/**
	 * Gets the nearest event by city.
	 *
	 * @param name the name
	 * @return the nearest event by city
	 */
	@ApiOperation(value = "Geo Search on AsciiName", notes = "Geo Search City by AsciiName")
	@RequestMapping(value = "/getNearestEventByCity", method = RequestMethod.GET)
	public Response<?> getNearestEventByCity(@RequestParam(value = "name") String name) {
		Response<?> response = null;
		try {
//			CityDTO cityDTO = geoDataSearchService.searchCityByName(name);
//			response = ResponseBuilder.buildOkResponse(Lists.newArrayList(cityDTO), HttpStatus.OK, "");
		} catch (Exception e) {
			return ResponseBuilder.buildErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		return response;
	}

	/**
	 * Gets the nearest event.
	 *
	 * @param geoPoint the geo point
	 * @param distance the distance
	 * @return the nearest event
	 */
	@ApiOperation(value = "Get nearest event", notes = "Get nearest event")
	@RequestMapping(value = "/getNearestEvent", method = RequestMethod.GET)
	public Response<?> getNearestEvent(@RequestParam(value = "geoPoint") String geoPoint,
			@RequestParam(value = "distance", required = false) String distance) {
		Response<?> response = null;
		try {
			if (StringUtils.isEmpty(distance)) {
				distance = "10";
			}
//			List<CityDTO> cityDTO = geoDataSearchService.searchCityByGeoPoint(geoPoint, distance);
//			response = ResponseBuilder.buildOkResponse(cityDTO, HttpStatus.OK, "");
		} catch (Exception e) {
			return ResponseBuilder.buildErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		return response;
	}
	
}
