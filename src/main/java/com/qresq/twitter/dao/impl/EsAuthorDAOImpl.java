package com.qresq.twitter.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.qresq.twitter.dao.EsAuthorDAO;
import com.qresq.twitter.elastic.builder.QueryBuilderHelper;
import com.qresq.twitter.elastic.core.ElasticEntityManager;
import com.qresq.twitter.elastic.core.ElasticException;
import com.qresq.twitter.elastic.core.EntityMapper;
import com.qresq.twitter.elastic.core.EsQuery;
import com.qresq.twitter.elastic.core.EsQuery.EsQueryIntMode;
import com.qresq.twitter.elastic.enums.EsModeQuery;
import com.qresq.twitter.elastic.model.AuthorEsBean;
import com.qresq.twitter.elastic.model.ResearchPaperEsBean;
import com.qresq.twitter.exception.DAOException;

/**
 * The Class EsEventDAOImpl.
 */
@Component
public class EsAuthorDAOImpl implements EsAuthorDAO {

	/** The Constant logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(EsAuthorDAOImpl.class);

	/** The entity manager. */
	@Autowired
	private ElasticEntityManager entityManager;

	@Override
	public boolean injectAuthorData(List<AuthorEsBean> authorList) throws DAOException {
		try {
			if (entityManager.validateIndex(AuthorEsBean.AUTHOR_INDEX, AuthorEsBean.AUTHOR_DOC_TYPE, AuthorEsBean.class)) {
				entityManager.saveAll(authorList, AuthorEsBean.AUTHOR_INDEX, AuthorEsBean.AUTHOR_DOC_TYPE);
			}
		} catch (ElasticException e) {
			throw new DAOException(e.getMessage());
		}
		return false;
	}

	@Override
	public List<AuthorEsBean> searchById(List<Long> authorIds) throws DAOException {
		List<AuthorEsBean> eventList = new ArrayList<>();
		try {
			List<EsQuery> authSearchQuery = QueryBuilderHelper.getSearchQueryForId(authorIds, Lists.newArrayList("authId"));

			QueryBuilder searchQueryBuilder = QueryBuilderHelper.search(authSearchQuery, EsQueryIntMode.MUST);
			SearchResponse response = entityManager.executeQuery(searchQueryBuilder, null, 0, 20, AuthorEsBean.AUTHOR_INDEX,
					null, null, null);
			SearchHit[] dataList = response.getHits().getHits();
			for (SearchHit hit : dataList) {
				eventList.add(EntityMapper.getInstance().getObject(hit.getSourceAsString(), AuthorEsBean.class));
			}
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return eventList;
	}

	@Override
	public List<AuthorEsBean> searchByText(String text) throws DAOException {
		List<AuthorEsBean> eventList = new ArrayList<>();
		try {
			List<EsQuery> authSearchQuery = new ArrayList<>();
			
			EsQuery query = new EsQuery("name", text, EsModeQuery.MATCH, EsQueryIntMode.MUST);
			authSearchQuery.add(query);
					
			QueryBuilder searchQueryBuilder = QueryBuilderHelper.search(authSearchQuery, EsQueryIntMode.MUST);
			SearchResponse response = entityManager.executeQuery(searchQueryBuilder, null, 0, 20, AuthorEsBean.AUTHOR_INDEX,
					null, null, null);
			SearchHit[] dataList = response.getHits().getHits();
			for (SearchHit hit : dataList) {
				eventList.add(EntityMapper.getInstance().getObject(hit.getSourceAsString(), AuthorEsBean.class));
			}
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return eventList;
	}

	@Override
	public List<AuthorEsBean> topAuthors() throws DAOException {
		List<AuthorEsBean> researhPaperList = new ArrayList<>();
		try {
//			List<EsQuery> geoSearchQuery = QueryBuilderHelper.getSearchQuery(Lists.newArrayList("2018"),
//					Lists.newArrayList("yyyy.keyword"));
//
//			QueryBuilder searchQueryBuilder = QueryBuilderHelper.search(geoSearchQuery, EsQueryIntMode.MUST);
			SearchResponse response = entityManager.executeQuery(null, null, 0, 20,
					AuthorEsBean.AUTHOR_INDEX, "hindex", org.elasticsearch.search.sort.SortOrder.DESC,
					null);
			SearchHit[] dataList = response.getHits().getHits();
			for (SearchHit hit : dataList) {
				researhPaperList
						.add(EntityMapper.getInstance().getObject(hit.getSourceAsString(), AuthorEsBean.class));
			}
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return researhPaperList;
	}
	
	

}
