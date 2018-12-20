package com.qresq.twitter.elastic.core;

import lombok.Data;

/**
 * The Class EsSort.
 */
@Data
public class EsSort {

	/** The sorting name. */
	private String sortingName;

	/** The sort field. */
	private String sortField;

	/** The value. */
	private Object value;

	/** The sort order. */
	private String sortOrder;

	/** The unit. */
	private String unit;

	/**
	 * Instantiates a new es sort.
	 *
	 * @param sortingName
	 *            the sorting name
	 * @param sortField
	 *            the sort field
	 * @param value
	 *            the value
	 * @param sorder
	 *            the sorder
	 */
	public EsSort(String sortingName, String sortField, Object value, String sorder) {
		this.sortingName = sortingName;
		this.sortField = sortField;
		this.value = value;
		this.sortOrder = sorder;
	}

	/**
	 * Instantiates a new es sort.
	 *
	 * @param sortingName
	 *            the sorting name
	 * @param sortField
	 *            the sort field
	 * @param value
	 *            the value
	 * @param sorder
	 *            the sorder
	 * @param unit
	 *            the unit
	 */
	public EsSort(String sortingName, String sortField, Object value, String sorder, String unit) {
		this(sortingName, sortField, value, sorder);
		this.unit = unit;
	}
}
