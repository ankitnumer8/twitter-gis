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

import com.qresq.twitter.dao.EsEventDAO;
import com.qresq.twitter.elastic.builder.QueryBuilderHelper;
import com.qresq.twitter.elastic.core.ElasticEntityManager;
import com.qresq.twitter.elastic.core.ElasticException;
import com.qresq.twitter.elastic.core.EntityMapper;
import com.qresq.twitter.elastic.core.EsQuery;
import com.qresq.twitter.elastic.core.EsQuery.EsQueryIntMode;
import com.qresq.twitter.elastic.enums.EsModeQuery;
import com.qresq.twitter.exception.DAOException;
import com.qresq.twitter.model.Event;

/**
 * The Class EsEventDAOImpl.
 */
@Component
public class EsEventDAOImpl implements EsEventDAO {

	/** The Constant logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(EsEventDAOImpl.class);

	/** The entity manager. */
	@Autowired
	private ElasticEntityManager entityManager;

	@Override
	public boolean injectEvents(List<Event> eventList) throws DAOException {
		try {
//			if (entityManager.validateIndex(Event.EVENT_INDEX, Event.EVENT_DOCTYPE, Event.class)) {
//				entityManager.saveAll(eventList, Event.EVENT_INDEX, Event.EVENT_DOCTYPE);
//			}
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return false;
	}

	@Override
	public List<Event> searchEventByGeoPoint(String geoPoint, String distance) throws DAOException {
		List<Event> eventList = new ArrayList<>();
		try {
			/*List<EsQuery> geoSearchQuery = new ArrayList<>();
			EsQuery query = new EsQuery("", geoPoint, distance, EsModeQuery.GEO_DISTANCE, EsQueryIntMode.MUST);
			geoSearchQuery.add(query);

			QueryBuilder searchQueryBuilder = QueryBuilderHelper.search(geoSearchQuery, EsQueryIntMode.FILTER);
			SearchResponse response = entityManager.executeQuery(searchQueryBuilder, null, 0, 20, Event.EVENT_INDEX,
					null, null, null);
			SearchHit[] dataList = response.getHits().getHits();
			for (SearchHit hit : dataList) {
				eventList.add(EntityMapper.getInstance().getObject(hit.getSourceAsString(), Event.class));
			}*/
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return eventList;
	}

}
