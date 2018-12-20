package com.qresq.twitter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qresq.twitter.elastic.config.ElasticConfiguration;
import com.qresq.twitter.elastic.core.ElasticEntityManager;
import com.qresq.twitter.elastic.core.ElasticServer;

@Configuration
public class AppElasticConfiguration implements ElasticConfiguration {

    /** The elastic hosts. */
    @Value("${elasticsearch.host}")
    private String elasticHosts;

    /** The elastic port. */
    @Value("${elasticsearch.port}")
    private String elasticPort;

    /**
     * Entity manager.
     *
     * @return the elastic entity manager
     * @throws Exception the exception
     */
    @Bean
    public ElasticEntityManager entityManager() throws Exception {
        ElasticEntityManager entityManager = ElasticEntityManager.getInstance();
        ElasticServer elasticServer = elasticServer();
        entityManager.openSessionTransport(elasticServer);
        return entityManager;
    }

    @Override
    public String getElasticHost() {
        return elasticHosts;
    }

    @Override
    public String getElasticPort() {
        return elasticPort;
    }
}
