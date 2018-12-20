package com.qresq.twitter.elastic.enums;

/**
 * The Enum EsModeQuery.
 * 
 * @author ankit.gupta4
 */
public enum EsModeQuery {

    /** The match. */
    MATCH,

    /** The match all. */
    MATCH_ALL,

    /** The range. */
    RANGE,

    GEO_DISTANCE,

    /** The term. */
    TERM,

    /** The term. */
    TERMS,

    /** The exists. */
    EXISTS,

    /** The query string query. */
    QUERY_STRING_QUERY,
    
    /** The more like this. */
    MORE_LIKE_THIS;
}