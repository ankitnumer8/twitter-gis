package com.qresq.twitter.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.qresq.twitter.dao.EsGithubDAO;
import com.qresq.twitter.dto.PdfDTO;
import com.qresq.twitter.elastic.builder.QueryBuilderHelper;
import com.qresq.twitter.elastic.core.ElasticEntityManager;
import com.qresq.twitter.elastic.core.ElasticException;
import com.qresq.twitter.elastic.core.EsQuery;
import com.qresq.twitter.elastic.core.EsQuery.EsQueryIntMode;
import com.qresq.twitter.elastic.enums.EsModeQuery;
import com.qresq.twitter.elastic.model.GitRepoEsBean;
import com.qresq.twitter.elastic.model.GithubEsBean;
import com.qresq.twitter.exception.DAOException;
import com.qresq.twitter.model.Event;

/**
 * The Class EsEventDAOImpl.
 */
@Component
public class EsGithubDAOImpl implements EsGithubDAO {

	/** The Constant logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(EsGithubDAOImpl.class);

	/** The entity manager. */
	@Autowired
	private ElasticEntityManager entityManager;

	@Override
	public boolean injectGithubData(List<GithubEsBean> githubList) throws DAOException {
		try {
			if (entityManager.validateIndex(GithubEsBean.GITHUB_INDEX, GithubEsBean.GITHUB_DOC_TYPE, GithubEsBean.class)) {
				entityManager.saveAll(githubList, GithubEsBean.GITHUB_INDEX, GithubEsBean.GITHUB_DOC_TYPE);
			}
		} catch (ElasticException e) {
			throw new DAOException(e.getMessage());
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean injectGitRepoData(List<GitRepoEsBean> gitRepoList) throws DAOException {
		try {
			if (entityManager.validateIndex(GitRepoEsBean.GITREPO_INDEX, GitRepoEsBean.GITREPO_DOC_TYPE,
					GitRepoEsBean.class)) {
				entityManager.saveAll(gitRepoList, GitRepoEsBean.GITREPO_INDEX, GitRepoEsBean.GITREPO_DOC_TYPE);
			}
		} catch (ElasticException e) {
			throw new DAOException(e.getMessage());
		}
		return false;
	}

	@Override
	public SearchResponse searchByReleasePaper(String arxId) throws DAOException {
		SearchResponse response = null;
		try {
			EsQuery query = new EsQuery("arxivIds", arxId, EsModeQuery.MATCH, EsQueryIntMode.MUST);

			QueryBuilder searchQueryBuilder = QueryBuilderHelper.search(Lists.newArrayList(query), EsQueryIntMode.MUST);
			response = entityManager.executeQuery(searchQueryBuilder, null, 0, 10, GithubEsBean.GITHUB_INDEX, null,
					null, null);
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SearchResponse searchByReadmeContent(String readmeContent) throws DAOException {
		SearchResponse response = null;
		try {
			EsQuery query = new EsQuery("readme", readmeContent, EsModeQuery.QUERY_STRING_QUERY, EsQueryIntMode.MUST);

			QueryBuilder searchQueryBuilder = QueryBuilderHelper.search(Lists.newArrayList(query), EsQueryIntMode.MUST);
			response = entityManager.executeQuery(searchQueryBuilder, null, 0, 10, GitRepoEsBean.GITREPO_INDEX, null,
					null, null);
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return response;
	}

	@Override
	public SearchResponse searchByReleasePaper(PdfDTO paper) throws DAOException {
		SearchResponse response = null;
		try {
			List<EsQuery> searchList = new ArrayList<>();
			EsQuery query = null;
			if (StringUtils.isNotEmpty(paper.getArxivId())) {
				query = new EsQuery("readme", paper.getArxivId(), EsModeQuery.MATCH, EsQueryIntMode.MUST);
				searchList.add(query);
			}

			if (StringUtils.isNotEmpty(paper.getUrl())) {
				query = new EsQuery("readme", paper.getUrl(), EsModeQuery.MATCH, EsQueryIntMode.MUST);
				searchList.add(query);
			}

			if (StringUtils.isNotEmpty(paper.getTitle())) {
				query = new EsQuery("readme", paper.getTitle(), EsModeQuery.QUERY_STRING_QUERY, EsQueryIntMode.MUST, false, false);
				searchList.add(query);
			}

			QueryBuilder searchQueryBuilder = QueryBuilderHelper.search(searchList, EsQueryIntMode.SHOULD);
			response = entityManager.executeQuery(searchQueryBuilder, null, 0, 10, GitRepoEsBean.GITREPO_INDEX, null,
					null, null);
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return response;
	}

}
