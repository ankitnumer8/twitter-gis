package com.qresq.twitter.dao;

import java.util.List;

import com.qresq.twitter.elastic.model.TopicEsBean;
import com.qresq.twitter.exception.DAOException;

/**
 * The Interface EsTopicDAO.
 */
public interface EsTopicDAO {

	/**
	 * Inject topic data.
	 *
	 * @param topicList
	 *            the topic list
	 * @return true, if successful
	 * @throws DAOException
	 *             the DAO exception
	 */
	boolean injectTopicData(List<TopicEsBean> topicList) throws DAOException;

	/**
	 * Search by id.
	 *
	 * @param topicIds
	 *            the topic ids
	 * @return the list
	 * @throws DAOException
	 *             the DAO exception
	 */
	public List<TopicEsBean> searchById(List<String> topicIds) throws DAOException;

}
