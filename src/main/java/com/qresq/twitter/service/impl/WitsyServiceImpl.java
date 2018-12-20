package com.qresq.twitter.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qresq.twitter.dao.EsWitsyDAO;
import com.qresq.twitter.elastic.core.EntityMapper;
import com.qresq.twitter.exception.DAOException;
import com.qresq.twitter.exception.ServiceException;
import com.qresq.twitter.service.WitsyService;
import com.qresq.twitter.service.request.QueryRequest;

/**
 * The Class HotelUploadServiceImpl.
 */
@Service
public class WitsyServiceImpl implements WitsyService {

    /** The logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(WitsyServiceImpl.class);

    @Autowired
    private EsWitsyDAO witsyDao;

    @Override
    public List<?> searchByDsl(QueryRequest queryDsl) throws ServiceException {
        List<?> results = new ArrayList<>();
        try {
            SearchResponse response = witsyDao.searchByDsl(queryDsl);
            SearchHit[] dataList = response.getHits().getHits();
            List<Object> resultList = new ArrayList<>();
            for (SearchHit hit : dataList) {
                Object object = EntityMapper.getInstance().getObject(hit.getSourceAsString(), Object.class);
                resultList.add(object);
            }

            if (CollectionUtils.isNotEmpty(resultList)) {
                results = resultList;
            }
        } catch (Exception e) {
            throw new ServiceException(e);
        }
        return results;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean ingestDocumentsInIndex(String file, String indexName, String docType, String idFieldName)
            throws ServiceException {
        try {
            return witsyDao.injectFile(file, indexName, docType, idFieldName);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
