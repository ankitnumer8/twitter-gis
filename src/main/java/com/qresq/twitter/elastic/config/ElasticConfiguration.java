/**
 * 
 */
package com.qresq.twitter.elastic.config;

import com.google.common.collect.Lists;
import com.qresq.twitter.elastic.core.ElasticServer;

/**
 * The Class ElasticConfiguration.
 *
 */
public interface ElasticConfiguration {

    /**
     * Gets the elastic host.
     *
     * @return the elastic host
     */
    String getElasticHost();

    /**
     * Gets the elastic port.
     *
     * @return the elastic port
     */
    String getElasticPort();

    /**
     * Elastic server.
     *
     * @return the elastic server
     * @throws Exception the exception
     */
    public default ElasticServer elasticServer() throws Exception {
        return new ElasticServer(Lists.newArrayList(getElasticHost()), Integer.parseInt(getElasticPort()));
    }

}
