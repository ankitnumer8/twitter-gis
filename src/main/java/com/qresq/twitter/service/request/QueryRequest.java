package com.qresq.twitter.service.request;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.qresq.twitter.dto.CommonDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Instantiates a new query request.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class QueryRequest extends CommonDTO{

	/** The index name. */
	@NotNull
	private String indexName = null;

	/** The filters. */
	private List<QueryFilterInfo> filters;

	/** The sort field. */
	private String sortField;

	/** The sort order. */
	private String sortOrder;
	
	/** The from. */
	private int from;
	
	/** The size. */
	private int size;
	
	/** The exact match. */
	private boolean exactMatch = false;

}
