package com.qresq.twitter.elastic.builder;

import java.util.HashMap;

import org.elasticsearch.search.suggest.completion.CompletionSuggestionBuilder;

public class CompletionBuilder extends HashMap<String, CompletionSuggestionBuilder> {

    /**
     * The serial version.
     */
    private static final long serialVersionUID = 5459477721339920037L;

    /**
     * Default constructor.
     */
    public CompletionBuilder() {
        super();
    }
}
