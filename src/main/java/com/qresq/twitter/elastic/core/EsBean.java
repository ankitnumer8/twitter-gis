package com.qresq.twitter.elastic.core;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class EsInner.
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class EsBean implements Serializable {

    /** Comment for <code>serialVersionUID</code>. */
    private static final long serialVersionUID = 1L;

    /** The Constant ID. */
    public static final String ID = "id";

    /** The id. */
    @JsonIgnore
    private String id;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

}
