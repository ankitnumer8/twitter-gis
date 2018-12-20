package com.qresq.twitter.dao;

import org.elasticsearch.action.search.SearchResponse;

import com.qresq.twitter.exception.DAOException;
import com.qresq.twitter.service.request.QueryRequest;

public interface EsWitsyDAO {

    /**
     * Search event by geo point.
     *
     * @param authorIds the author ids
     * @return the list
     * @throws DAOException the DAO exception
     */
    public SearchResponse searchByDsl(QueryRequest queryRequest) throws DAOException;

    /**
     * Inject file.
     *
     * @param file the file
     * @param indexName the index name
     * @param docType the doc type
     * @param idFieldName the id field name
     * @return the boolean
     * @throws DAOException the DAO exception
     */
    Boolean injectFile(String file, String indexName, String docType, String idFieldName) throws DAOException;

}
