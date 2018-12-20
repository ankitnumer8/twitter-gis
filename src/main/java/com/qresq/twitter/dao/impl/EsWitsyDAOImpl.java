package com.qresq.twitter.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qresq.twitter.dao.EsWitsyDAO;
import com.qresq.twitter.elastic.builder.QueryBuilderHelper;
import com.qresq.twitter.elastic.core.ElasticEntityManager;
import com.qresq.twitter.elastic.core.ElasticException;
import com.qresq.twitter.elastic.core.EsQuery;
import com.qresq.twitter.elastic.core.EsQuery.EsQueryIntMode;
import com.qresq.twitter.elastic.enums.EsModeQuery;
import com.qresq.twitter.exception.DAOException;
import com.qresq.twitter.service.request.QueryFilterInfo;
import com.qresq.twitter.service.request.QueryRequest;

/**
 * The Class EsEventDAOImpl.
 */
@Component
public class EsWitsyDAOImpl implements EsWitsyDAO {

    /** The Constant logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(EsWitsyDAOImpl.class);

    /** The entity manager. */
    @Autowired
    private ElasticEntityManager entityManager;

    @Override
    public SearchResponse searchByDsl(QueryRequest queryRequest) throws DAOException {
        SearchResponse response = null;
        try {
            String indexName = queryRequest.getIndexName();
            int from = queryRequest.getFrom();
            int size = queryRequest.getSize() == 0 ? 20 : queryRequest.getSize();
            SortOrder sortOrder = null;
            if (StringUtils.isNotEmpty(queryRequest.getSortOrder())) {
                sortOrder = queryRequest.getSortOrder().equals("desc") ? SortOrder.DESC : SortOrder.ASC;
            }
            List<EsQuery> queryList = buildEsQuery(queryRequest);
            QueryBuilder searchQueryBuilder = QueryBuilderHelper.search(queryList,
                    queryRequest.isExactMatch() ? EsQueryIntMode.MUST : EsQueryIntMode.SHOULD);
            response = entityManager.executeQuery(searchQueryBuilder, null, from, size, indexName,
                    queryRequest.getSortField(), sortOrder, null);
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return response;
    }

    /**
     * Builds the es query.
     *
     * @param queryRequest the query request
     * @return the list
     */
    private List<EsQuery> buildEsQuery(QueryRequest queryRequest) {
        List<EsQuery> esQueryList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(queryRequest.getFilters())) {
            for (QueryFilterInfo filter : queryRequest.getFilters()) {
                EsQuery query = new EsQuery(filter.getFieldName(), filter.getValue(), EsModeQuery.MATCH);
                esQueryList.add(query);
            }
        }
        return esQueryList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean injectFile(String jsonFile, String indexName, String docType, String idFieldName)
            throws DAOException {
        try {
            return entityManager.saveAll(jsonFile, indexName, docType, idFieldName);
        } catch (ElasticException e) {
            LOGGER.error(e.getMessage(), e);
            throw new DAOException(e);
        }
    }

}
