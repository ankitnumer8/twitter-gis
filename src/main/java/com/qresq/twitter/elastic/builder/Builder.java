/**
 * 
 */
package com.qresq.twitter.elastic.builder;

import org.elasticsearch.action.ActionResponse;

/**
 * The Interface Builder.
 *
 * @author ankit.gupta4
 * @param <R> the generic type
 */
public interface Builder<R extends ActionResponse> {

	/**
	 * Get element.
	 *
	 * @return response of builder
	 */
	public R get();
}
