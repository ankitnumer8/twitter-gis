/**
 * 
 */
package com.qresq.twitter.model;

import lombok.Data;

/**
 * The Class CitySuggestBean.
 *
 * @author ankit
 */
@Data
public class SuggestBean {

	/** The input. */
	private Object input;
	
	/** The weight. */
	private Integer weight;
	
	
	/**
	 * Instantiates a new city suggest bean.
	 *
	 * @param input the input
	 * @param weight the weight
	 */
	public SuggestBean() {
	}
	
	/**
	 * Instantiates a new city suggest bean.
	 *
	 * @param input the input
	 * @param weight the weight
	 */
	public SuggestBean(Object input, Integer weight) {
		this.input = input;
		this.weight = weight;
	}

}
