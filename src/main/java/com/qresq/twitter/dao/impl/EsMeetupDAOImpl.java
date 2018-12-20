package com.qresq.twitter.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.qresq.twitter.dao.EsMeetupDAO;
import com.qresq.twitter.dao.EsUsecaseDAO;
import com.qresq.twitter.dto.ResearchPaperMetaDTO;
import com.qresq.twitter.elastic.builder.QueryBuilderHelper;
import com.qresq.twitter.elastic.core.ElasticEntityManager;
import com.qresq.twitter.elastic.core.ElasticException;
import com.qresq.twitter.elastic.core.EntityMapper;
import com.qresq.twitter.elastic.core.EsQuery;
import com.qresq.twitter.elastic.core.EsSort;
import com.qresq.twitter.elastic.core.EsQuery.EsQueryIntMode;
import com.qresq.twitter.elastic.enums.EsModeQuery;
import com.qresq.twitter.elastic.model.MeetupEsBean;
import com.qresq.twitter.elastic.model.ResearchPaperEsBean;
import com.qresq.twitter.elastic.model.UsecaseEsBean;
import com.qresq.twitter.exception.DAOException;
import com.qresq.twitter.model.Event;

/**
 * The Class EsEventDAOImpl.
 */
@Component
public class EsMeetupDAOImpl implements EsMeetupDAO {

	/** The Constant logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(EsMeetupDAOImpl.class);

	/** The entity manager. */
	@Autowired
	private ElasticEntityManager entityManager;

	@Override
	public boolean injectData(List<MeetupEsBean> data) throws DAOException {
		try {
			if (entityManager.validateIndex(MeetupEsBean.MEETUP_INDEX, MeetupEsBean.MEETUP_DOC_TYPE,
					MeetupEsBean.class)) {
				entityManager.saveAll(data, MeetupEsBean.MEETUP_INDEX, MeetupEsBean.MEETUP_DOC_TYPE);
			}
		} catch (ElasticException e) {
			throw new DAOException(e.getMessage());
		}
		return false;
	}

	@Override
	public List<MeetupEsBean> searchByTag(List<String> tagIds) throws DAOException {
		List<MeetupEsBean> researhPaperList = new ArrayList<>();
		try {
			List<EsQuery> geoSearchQuery = QueryBuilderHelper.getSearchQuery(Lists.newArrayList(tagIds),
					Lists.newArrayList("tags.tagId"));

			QueryBuilder searchQueryBuilder = QueryBuilderHelper.search(geoSearchQuery, EsQueryIntMode.MUST);
			SearchResponse response = entityManager.executeQuery(searchQueryBuilder, null, 0, 20,
					MeetupEsBean.MEETUP_INDEX, null);
			SearchHit[] dataList = response.getHits().getHits();
			for (SearchHit hit : dataList) {
				researhPaperList.add(EntityMapper.getInstance().getObject(hit.getSourceAsString(), MeetupEsBean.class));
			}
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return researhPaperList;
	}

	@Override
	public List<MeetupEsBean> searchEventByGeoPoint(String geoPoint, String distance) throws DAOException {
		List<MeetupEsBean> eventList = new ArrayList<>();
		try {
			List<EsQuery> geoSearchQuery = new ArrayList<>();
			EsQuery query = new EsQuery("eventNewGeoLocation", geoPoint, distance, EsModeQuery.GEO_DISTANCE,
					EsQueryIntMode.MUST);
			geoSearchQuery.add(query);

			QueryBuilder searchQueryBuilder = QueryBuilderHelper.search(geoSearchQuery, EsQueryIntMode.FILTER);
			EsSort sort = new EsSort("eventNewGeoLocation", "eventNewGeoLocation", geoPoint, "ASC", "km");
			SearchResponse response = entityManager.executeQuery(searchQueryBuilder, null, 0, 20,
					MeetupEsBean.MEETUP_INDEX, sort);
			SearchHit[] dataList = response.getHits().getHits();
			for (SearchHit hit : dataList) {
				eventList.add(EntityMapper.getInstance().getObject(hit.getSourceAsString(), MeetupEsBean.class));
			}
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return eventList;
	}

	@Override
	public List<MeetupEsBean> searchByText(String text) throws DAOException {
		List<MeetupEsBean> eventList = new ArrayList<>();
		try {
			List<EsQuery> authSearchQuery = new ArrayList<>();
			EsQuery query = new EsQuery("title", text, EsModeQuery.MATCH, EsQueryIntMode.MUST);
			authSearchQuery.add(query);

			query = new EsQuery("description", text, EsModeQuery.MATCH, EsQueryIntMode.MUST);
			authSearchQuery.add(query);

			query = new EsQuery("tags.tag", text, EsModeQuery.MATCH, EsQueryIntMode.MUST);
			authSearchQuery.add(query);

			QueryBuilder searchQueryBuilder = QueryBuilderHelper.search(authSearchQuery, EsQueryIntMode.SHOULD);
			SearchResponse response = entityManager.executeQuery(searchQueryBuilder, null, 0, 20,
					MeetupEsBean.MEETUP_INDEX, null, null, null);
			SearchHit[] dataList = response.getHits().getHits();
			for (SearchHit hit : dataList) {
				eventList.add(EntityMapper.getInstance().getObject(hit.getSourceAsString(), MeetupEsBean.class));
			}
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return eventList;
	}

}
