package com.qresq.twitter.service;

import java.util.List;

import com.qresq.twitter.exception.ServiceException;
import com.qresq.twitter.service.request.QueryRequest;

/**
 * The Interface WitsyService.
 */
public interface WitsyService {

    /**
     * Search by dsl.
     *
     * @param queryDsl the query dsl
     * @return the list
     * @throws ServiceException the service exception
     */
    public List<?> searchByDsl(QueryRequest queryDsl) throws ServiceException;

    /**
     * Ingest documents in index.
     *
     * @param file the file
     * @param indexName the index name
     * @param docType the doc type
     * @param idFieldName the id field name
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    public boolean ingestDocumentsInIndex(String file, String indexName, String docType, String idFieldName)
            throws ServiceException;

}
