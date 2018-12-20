package com.qresq.twitter.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.qresq.twitter.dao.EsUsecaseDAO;
import com.qresq.twitter.elastic.builder.QueryBuilderHelper;
import com.qresq.twitter.elastic.core.ElasticEntityManager;
import com.qresq.twitter.elastic.core.ElasticException;
import com.qresq.twitter.elastic.core.EntityMapper;
import com.qresq.twitter.elastic.core.EsQuery;
import com.qresq.twitter.elastic.core.EsQuery.EsQueryIntMode;
import com.qresq.twitter.elastic.enums.EsModeQuery;
import com.qresq.twitter.elastic.model.UsecaseEsBean;
import com.qresq.twitter.exception.DAOException;

/**
 * The Class EsEventDAOImpl.
 */
@Component
public class EsUsecaseDAOImpl implements EsUsecaseDAO {

	/** The Constant logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(EsUsecaseDAOImpl.class);

	/** The entity manager. */
	@Autowired
	private ElasticEntityManager entityManager;

	@Override
	public boolean injectData(List<UsecaseEsBean> usecasList) throws DAOException {
		try {
			if (entityManager.validateIndex(UsecaseEsBean.USECASE_INDEX, UsecaseEsBean.USECASE_DOC_TYPE,
					UsecaseEsBean.class)) {
				entityManager.saveAll(usecasList, UsecaseEsBean.USECASE_INDEX, UsecaseEsBean.USECASE_DOC_TYPE);
			}
		} catch (ElasticException e) {
			throw new DAOException(e.getMessage());
		}
		return false;
	}

	@Override
	public List<UsecaseEsBean> searchByCategory(List<String> categoryList) throws DAOException {
		List<UsecaseEsBean> eventList = new ArrayList<>();
		try {
			List<EsQuery> authSearchQuery = new ArrayList<>();
			EsQuery query = new EsQuery("category", categoryList, EsModeQuery.MATCH, EsQueryIntMode.MUST);

			authSearchQuery.add(query);

			QueryBuilder searchQueryBuilder = QueryBuilderHelper.search(authSearchQuery, EsQueryIntMode.MUST);
			SearchResponse response = entityManager.executeQuery(searchQueryBuilder, null, 0, 20,
					UsecaseEsBean.USECASE_INDEX, null, null, null);
			SearchHit[] dataList = response.getHits().getHits();
			for (SearchHit hit : dataList) {
				eventList.add(EntityMapper.getInstance().getObject(hit.getSourceAsString(), UsecaseEsBean.class));
			}
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return eventList;
	}

	@Override
	public List<UsecaseEsBean> searchById(List<String> usercaseIdList) throws DAOException {
		List<UsecaseEsBean> eventList = new ArrayList<>();
		try {
			List<EsQuery> authSearchQuery = QueryBuilderHelper.getSearchQuery(usercaseIdList,
					Lists.newArrayList("uid"));

			QueryBuilder searchQueryBuilder = QueryBuilderHelper.search(authSearchQuery, EsQueryIntMode.MUST);
			SearchResponse response = entityManager.executeQuery(searchQueryBuilder, null, 0, 20,
					UsecaseEsBean.USECASE_INDEX, null, null, null);
			SearchHit[] dataList = response.getHits().getHits();
			for (SearchHit hit : dataList) {
				eventList.add(EntityMapper.getInstance().getObject(hit.getSourceAsString(), UsecaseEsBean.class));
			}
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return eventList;
	}

	@Override
	public List<UsecaseEsBean> searchByText(String text) throws DAOException {
		List<UsecaseEsBean> eventList = new ArrayList<>();
		try {
			List<EsQuery> authSearchQuery = new ArrayList<>();
			if (StringUtils.isNotEmpty(text)) {
				EsQuery query = new EsQuery("title", text, EsModeQuery.MATCH, EsQueryIntMode.MUST);
				authSearchQuery.add(query);

				query = new EsQuery("description", text, EsModeQuery.MATCH, EsQueryIntMode.MUST);
				authSearchQuery.add(query);
			}
			QueryBuilder searchQueryBuilder = QueryBuilderHelper.search(authSearchQuery, EsQueryIntMode.MUST);
			SearchResponse response = entityManager.executeQuery(searchQueryBuilder, null, 0, 20,
					UsecaseEsBean.USECASE_INDEX, null, null, null);
			SearchHit[] dataList = response.getHits().getHits();
			for (SearchHit hit : dataList) {
				eventList.add(EntityMapper.getInstance().getObject(hit.getSourceAsString(), UsecaseEsBean.class));
			}
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return eventList;
	}

}
