package com.qresq.twitter.elastic.builder;

import java.util.List;

import org.elasticsearch.search.suggest.completion.CompletionSuggestionBuilder;

import com.qresq.twitter.elastic.core.EsSuggest;

public class CompletionBuilderHelper {

	private CompletionBuilderHelper() {
    }
    
    /**
     * Create an suggestion query.
     * 
     * @param suggests list of suggestion to add in the query.
     * @return an suggestion query.
     */
    public static CompletionBuilder suggest(List<EsSuggest> suggests) {
        CompletionBuilder builder = new CompletionBuilder();
        for (EsSuggest esSuggest : suggests) {
            String fieldname = esSuggest.getFieldname();
            String value = esSuggest.getValue();
            CompletionSuggestionBuilder completionSuggestionBuilder = new CompletionSuggestionBuilder(fieldname);
            completionSuggestionBuilder.prefix(value);
            builder.put(fieldname, completionSuggestionBuilder);
        }
        return builder;
    }
}
