package com.qresq.twitter.controller;

import java.util.List;

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
import com.qresq.twitter.elastic.model.GpuEsBean;
import com.qresq.twitter.elastic.model.UsecaseEsBean;
import com.qresq.twitter.service.GpuService;
import com.qresq.twitter.service.response.ResearchPaperResponse;
import com.qresq.twitter.service.response.Response;
import com.qresq.twitter.service.response.ResponseBuilder;

import io.swagger.annotations.ApiOperation;

/**
 * The Class HotelUploadController.
 */
@RestController
@RequestMapping(GpuController.API_GPU_URL)
public class GpuController {

	/** The logger. */
	private static final Logger logger = LoggerFactory.getLogger(GpuController.class);

	/** The Constant API_READ_URL. */
	public static final String API_GPU_URL = "/api/gpu";

	/** The event service. */
	@Autowired
	private GpuService gpuService;

	@ApiOperation(value = "GPU", notes = "GPU save Data")
	@RequestMapping(value = "/saveGpu", method = RequestMethod.POST)
	public ResponseEntity<?> ingestGPUData(@RequestParam("file") String fileName) {
		try {
			gpuService.saveGpuData(fileName);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	/**
	 * Gets the nearest event by city.
	 *
	 * @param name
	 *            the name
	 * @return the nearest event by city
	 */
	@ApiOperation(value = "Find GPU by Company", notes = "Find GPU by Company")
	@RequestMapping(value = "/searchByCompany", method = RequestMethod.GET)
	public Response<?> getGpuByCompany(@RequestParam(value = "name") String name) {
		Response<?> response = null;
		try {
			List<GpuEsBean> gpusList = gpuService.searchByCompany(Lists.newArrayList(name));
			response = ResponseBuilder.buildOkResponse(gpusList, HttpStatus.OK, "");
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
	@ApiOperation(value = "Search GPU", notes = "Search GPU")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public Response<?> search(@RequestParam(value = "text", required = false) String searchText) {
		Response<?> response = null;
		try {
			List<GpuEsBean> gpusList = gpuService.searchByText(searchText);
			response = ResponseBuilder.buildOkResponse(gpusList, HttpStatus.OK, "");
		} catch (Exception e) {
			return ResponseBuilder.buildErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		return response;
	}

}
