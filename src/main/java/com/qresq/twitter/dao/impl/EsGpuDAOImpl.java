package com.qresq.twitter.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.qresq.twitter.dao.EsGpuDAO;
import com.qresq.twitter.elastic.builder.QueryBuilderHelper;
import com.qresq.twitter.elastic.core.ElasticEntityManager;
import com.qresq.twitter.elastic.core.ElasticException;
import com.qresq.twitter.elastic.core.EntityMapper;
import com.qresq.twitter.elastic.core.EsQuery;
import com.qresq.twitter.elastic.core.EsQuery.EsQueryIntMode;
import com.qresq.twitter.elastic.enums.EsModeQuery;
import com.qresq.twitter.elastic.model.GpuEsBean;
import com.qresq.twitter.exception.DAOException;

/**
 * The Class EsEventDAOImpl.
 */
@Component
public class EsGpuDAOImpl implements EsGpuDAO {

	/** The Constant logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(EsGpuDAOImpl.class);

	/** The entity manager. */
	@Autowired
	private ElasticEntityManager entityManager;

	@Override
	public boolean injectGpuData(List<GpuEsBean> gpuList) throws DAOException {
		try {
			if (entityManager.validateIndex(GpuEsBean.GPU_INDEX, GpuEsBean.GPU_DOC_TYPE, GpuEsBean.class)) {
				entityManager.saveAll(gpuList, GpuEsBean.GPU_INDEX, GpuEsBean.GPU_DOC_TYPE);
			}
		} catch (ElasticException e) {
			throw new DAOException(e.getMessage());
		}
		return false;
	}

	@Override
	public List<GpuEsBean> searchByCompany(List<String> companyList) throws DAOException {
		List<GpuEsBean> eventList = new ArrayList<>();
		try {
			List<EsQuery> authSearchQuery = QueryBuilderHelper.getSearchQuery(companyList,
					Lists.newArrayList("company"));

			QueryBuilder searchQueryBuilder = QueryBuilderHelper.search(authSearchQuery, EsQueryIntMode.MUST);
			SearchResponse response = entityManager.executeQuery(searchQueryBuilder, null, 0, 20, GpuEsBean.GPU_INDEX,
					null, null, null);
			SearchHit[] dataList = response.getHits().getHits();
			for (SearchHit hit : dataList) {
				eventList.add(EntityMapper.getInstance().getObject(hit.getSourceAsString(), GpuEsBean.class));
			}
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return eventList;
	}

	@Override
	public List<GpuEsBean> searchByText(String text) throws DAOException {
		List<GpuEsBean> eventList = new ArrayList<>();
		try {
			List<EsQuery> authSearchQuery = new ArrayList<>();
			QueryBuilder searchQueryBuilder = null;
			if (StringUtils.isNotEmpty(text)) {
				EsQuery query = new EsQuery("company", text, EsModeQuery.QUERY_STRING_QUERY, EsQueryIntMode.MUST);
				authSearchQuery.add(query);
				searchQueryBuilder = QueryBuilderHelper.search(authSearchQuery, EsQueryIntMode.MUST);
			} else {
				searchQueryBuilder = QueryBuilderHelper.search(authSearchQuery, EsQueryIntMode.MUST);
			}
			SearchResponse response = entityManager.executeQuery(searchQueryBuilder, null, 0, 20, GpuEsBean.GPU_INDEX,
					null, null, null);
			SearchHit[] dataList = response.getHits().getHits();
			for (SearchHit hit : dataList) {
				eventList.add(EntityMapper.getInstance().getObject(hit.getSourceAsString(), GpuEsBean.class));
			}
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return eventList;
	}

}
