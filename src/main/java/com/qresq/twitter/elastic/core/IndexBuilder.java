package com.qresq.twitter.elastic.core;

import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;

import com.qresq.twitter.elastic.builder.Builder;

/**
 * Builder to execute the index query.
 * <P>
 * 
 * @author Sopra Steria.
 * @copyright � Airbus 2016. All rights reserved.
 */
public class IndexBuilder implements Builder<IndexResponse> {

    /**
     * Comment for <code>irb</code>
     */
    IndexRequestBuilder irb;

    /**
     * Default constructor.
     * 
     * @param irb e
     */
    public IndexBuilder(IndexRequestBuilder irb) {
        this.irb = irb;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IndexResponse get() {
        return irb.get();
    }

}
