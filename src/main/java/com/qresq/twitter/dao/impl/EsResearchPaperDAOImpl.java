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
import com.qresq.twitter.dao.EsResearchPaperDAO;
import com.qresq.twitter.dto.ResearchPaperMetaDTO;
import com.qresq.twitter.elastic.builder.CompletionBuilder;
import com.qresq.twitter.elastic.builder.CompletionBuilderHelper;
import com.qresq.twitter.elastic.builder.QueryBuilderHelper;
import com.qresq.twitter.elastic.core.ElasticEntityManager;
import com.qresq.twitter.elastic.core.ElasticException;
import com.qresq.twitter.elastic.core.EntityMapper;
import com.qresq.twitter.elastic.core.EsQuery;
import com.qresq.twitter.elastic.core.EsSuggest;
import com.qresq.twitter.elastic.core.EsQuery.EsQueryIntMode;
import com.qresq.twitter.elastic.enums.EsModeQuery;
import com.qresq.twitter.elastic.model.ResearchPaperEsBean;
import com.qresq.twitter.exception.DAOException;

/**
 * The Class EsEventDAOImpl.
 */
@Component
public class EsResearchPaperDAOImpl implements EsResearchPaperDAO {

	/** The Constant logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(EsResearchPaperDAOImpl.class);

	/** The entity manager. */
	@Autowired
	private ElasticEntityManager entityManager;

	@Override
	public boolean injectPublishedPaper(List<ResearchPaperEsBean> publishedPaper) throws DAOException {
		try {
			if (entityManager.validateIndex(ResearchPaperEsBean.RESEARCH_INDEX, ResearchPaperEsBean.RESEARCH_DOC_TYPE,
					ResearchPaperEsBean.class)) {
				entityManager.saveAll(publishedPaper, ResearchPaperEsBean.RESEARCH_INDEX,
						ResearchPaperEsBean.RESEARCH_DOC_TYPE);
			}
		} catch (ElasticException e) {
			throw new DAOException(e.getMessage());
		}
		return false;
	}

	@Override
	public List<ResearchPaperEsBean> publishedPaperSuggest(String text) throws DAOException {
		List<ResearchPaperEsBean> publishedList = new ArrayList<>();
		try {
			EsQuery query = new EsQuery("title", text, EsModeQuery.QUERY_STRING_QUERY, EsQueryIntMode.MUST);

			QueryBuilder searchQueryBuilder = QueryBuilderHelper.search(Lists.newArrayList(query), EsQueryIntMode.MUST);
			SearchResponse response = entityManager.executeQuery(searchQueryBuilder, null, 0, 10,
					ResearchPaperEsBean.RESEARCH_INDEX, null, null, null);
			SearchHit[] dataList = response.getHits().getHits();
			for (SearchHit hit : dataList) {
				publishedList
						.add(EntityMapper.getInstance().getObject(hit.getSourceAsString(), ResearchPaperEsBean.class));
			}
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return publishedList;
	}

	@Override
	public SearchResponse suggest(String suggestName, String text) throws DAOException {
		try {
			EsSuggest suggest = new EsSuggest(suggestName, text, "", null);
			List<EsSuggest> listSuggest = Lists.newArrayList(suggest);

			CompletionBuilder completionBuilder = CompletionBuilderHelper.suggest(listSuggest);
			return entityManager.executeSuggest(ResearchPaperEsBean.RESEARCH_INDEX, completionBuilder);
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public SearchResponse similarPaper(String docMeta) throws DAOException {
		try {
			EsQuery query = new EsQuery("title", docMeta, EsModeQuery.MORE_LIKE_THIS, EsQueryIntMode.MUST);
			QueryBuilder builder = query.toQuery();
			return entityManager.executeQuery(builder, null, 0, 10, ResearchPaperEsBean.RESEARCH_INDEX, null, null,
					Lists.newArrayList("title", "arxivId", "authors"));
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public ResearchPaperEsBean paperById(String docId) throws DAOException {
		ResearchPaperEsBean researhPaper = null;
		try {
			List<EsQuery> geoSearchQuery = QueryBuilderHelper.getSearchQuery(Lists.newArrayList(docId),
					Lists.newArrayList("arxivId"));

			QueryBuilder searchQueryBuilder = QueryBuilderHelper.search(geoSearchQuery, EsQueryIntMode.MUST);
			SearchResponse response = entityManager.executeQuery(searchQueryBuilder, null, 0, 20,
					ResearchPaperEsBean.RESEARCH_INDEX, null);
			if (response != null && response.getHits().getTotalHits() == 1) {
				researhPaper = EntityMapper.getInstance().getObject(response.getHits().getHits()[0].getSourceAsString(),
						ResearchPaperEsBean.class);
			}
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return researhPaper;
	}

	@Override
	public List<ResearchPaperMetaDTO> searchByTopic(List<String> tagIds) throws DAOException {
		List<ResearchPaperMetaDTO> researhPaperList = new ArrayList<>();
		try {
			List<EsQuery> geoSearchQuery = QueryBuilderHelper.getSearchQuery(Lists.newArrayList(tagIds),
					Lists.newArrayList("tags.tagId"));

			QueryBuilder searchQueryBuilder = QueryBuilderHelper.search(geoSearchQuery, EsQueryIntMode.MUST);
			SearchResponse response = entityManager.executeQuery(searchQueryBuilder, null, 0, 20,
					ResearchPaperEsBean.RESEARCH_INDEX, null);
			SearchHit[] dataList = response.getHits().getHits();
			for (SearchHit hit : dataList) {
				researhPaperList
						.add(EntityMapper.getInstance().getObject(hit.getSourceAsString(), ResearchPaperMetaDTO.class));
			}
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return researhPaperList;
	}

	@Override
	public List<ResearchPaperMetaDTO> searchByAuthor(List<String> authorIds) throws DAOException {
		List<ResearchPaperMetaDTO> researhPaperList = new ArrayList<>();
		try {
			List<EsQuery> geoSearchQuery = QueryBuilderHelper.getSearchQuery(Lists.newArrayList(authorIds),
					Lists.newArrayList("authors.authId"));

			QueryBuilder searchQueryBuilder = QueryBuilderHelper.search(geoSearchQuery, EsQueryIntMode.MUST);
			SearchResponse response = entityManager.executeQuery(searchQueryBuilder, null, 0, 20,
					ResearchPaperEsBean.RESEARCH_INDEX, null);
			SearchHit[] dataList = response.getHits().getHits();
			for (SearchHit hit : dataList) {
				researhPaperList
						.add(EntityMapper.getInstance().getObject(hit.getSourceAsString(), ResearchPaperMetaDTO.class));
			}
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return researhPaperList;
	}

	@Override
	public List<ResearchPaperEsBean> topResearchPaper() throws DAOException {
		List<ResearchPaperEsBean> researhPaperList = new ArrayList<>();
		try {
			List<EsQuery> geoSearchQuery = QueryBuilderHelper.getSearchQuery(Lists.newArrayList("2018"),
					Lists.newArrayList("yyyy.keyword"));

			QueryBuilder searchQueryBuilder = QueryBuilderHelper.search(geoSearchQuery, EsQueryIntMode.MUST);
			SearchResponse response = entityManager.executeQuery(searchQueryBuilder, null, 0, 20,
					ResearchPaperEsBean.RESEARCH_INDEX, "citations", org.elasticsearch.search.sort.SortOrder.DESC,
					null);
			SearchHit[] dataList = response.getHits().getHits();
			for (SearchHit hit : dataList) {
				researhPaperList
						.add(EntityMapper.getInstance().getObject(hit.getSourceAsString(), ResearchPaperEsBean.class));
			}
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return researhPaperList;
	}
}
