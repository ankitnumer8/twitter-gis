package com.qresq.twitter.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qresq.twitter.service.WitsyService;
import com.qresq.twitter.service.request.QueryRequest;
import com.qresq.twitter.service.response.Response;
import com.qresq.twitter.service.response.ResponseBuilder;

import io.swagger.annotations.ApiOperation;

/**
 * The Class HotelUploadController.
 */
@RestController
@RequestMapping(WitsyController.API_WITSY_URL)
public class WitsyController {

    /** The logger. */
    private static final Logger logger = LoggerFactory.getLogger(WitsyController.class);

    /** The Constant API_READ_URL. */
    public static final String API_WITSY_URL = "/api/witsy";

    /** The event service. */
    @Autowired
    private WitsyService witsyService;

    /**
     * Search query time.
     *
     * @param hotelText the hotel text
     * @return the response entity
     */
    @ApiOperation(value = "Search Witsy", notes = "Search Witsy")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Response<?> search(@RequestBody QueryRequest queryDsl) {
        Response<?> response = null;
        try {
            List<?> gpusList = witsyService.searchByDsl(queryDsl);
            response = ResponseBuilder.buildOkResponse(gpusList, HttpStatus.OK, "");
        } catch (Exception e) {
            return ResponseBuilder.buildErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return response;
    }

    /**
     * Ingest documents in index.
     *
     * @param fileName the file name
     * @param index the index
     * @param docType the doc type
     * @param idFieldName the id field name
     * @return the response entity
     */
    @ApiOperation(value = "ingestDocumentsInIndex", notes = "Inject json Data in provided index")
    @RequestMapping(value = "/ingestDocumentsInIndex", method = RequestMethod.POST)
    public ResponseEntity<?> ingestDocumentsInIndex(@RequestParam("file") String fileName,
            @RequestParam("index") String index, @RequestParam("docType") String docType,
            @RequestParam(name = "idFieldName", required = false) String idFieldName) {
        try {
            witsyService.ingestDocumentsInIndex(fileName, index, docType, idFieldName);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
