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
import com.qresq.twitter.dao.EsTopicDAO;
import com.qresq.twitter.elastic.builder.QueryBuilderHelper;
import com.qresq.twitter.elastic.core.ElasticEntityManager;
import com.qresq.twitter.elastic.core.ElasticException;
import com.qresq.twitter.elastic.core.EntityMapper;
import com.qresq.twitter.elastic.core.EsQuery;
import com.qresq.twitter.elastic.core.EsQuery.EsQueryIntMode;
import com.qresq.twitter.elastic.model.TopicEsBean;
import com.qresq.twitter.exception.DAOException;

/**
 * The Class EsEventDAOImpl.
 */
@Component
public class EsTopicDAOImpl implements EsTopicDAO {

	/** The Constant logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(EsTopicDAOImpl.class);

	/** The entity manager. */
	@Autowired
	private ElasticEntityManager entityManager;

	@Override
	public boolean injectTopicData(List<TopicEsBean> topicList) throws DAOException {
		try {
			if (entityManager.validateIndex(TopicEsBean.TOPIC_INDEX, TopicEsBean.TOPIC_DOC_TYPE, TopicEsBean.class)) {
				entityManager.saveAll(topicList, TopicEsBean.TOPIC_INDEX, TopicEsBean.TOPIC_DOC_TYPE);
			}
		} catch (ElasticException e) {
			throw new DAOException(e.getMessage());
		}
		return false;
	}

	@Override
	public List<TopicEsBean> searchById(List<String> topicIds) throws DAOException {
		List<TopicEsBean> eventList = new ArrayList<>();
		try {
			List<EsQuery> authSearchQuery = QueryBuilderHelper.getSearchQuery(topicIds, Lists.newArrayList("id"));
			QueryBuilder searchQueryBuilder = QueryBuilderHelper.search(authSearchQuery, EsQueryIntMode.MUST);
			SearchResponse response = entityManager.executeQuery(searchQueryBuilder, null, 0, 20,
					TopicEsBean.TOPIC_INDEX, null, null, null);
			SearchHit[] dataList = response.getHits().getHits();
			for (SearchHit hit : dataList) {
				eventList.add(EntityMapper.getInstance().getObject(hit.getSourceAsString(), TopicEsBean.class));
			}
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return eventList;
	}

}
