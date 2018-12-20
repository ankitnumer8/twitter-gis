/**
 * 
 */
package com.qresq.twitter.elastic.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qresq.twitter.elastic.core.EsBean;
import com.qresq.twitter.model.NormalPricing;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Class GpuEsBean.
 *
 * @author ankit.gupta
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GpuEsBean extends EsBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant EVENT_INDEX. */
	public static final String GPU_INDEX = "gpu_index";

	/** The Constant EVENT_DOCTYPE. */
	public static final String GPU_DOC_TYPE = "gpu_index";

	/** The core. */
	private String core;

	/** The numof GPU. */
	private String numofGPU;

	/** The os. */
	private String os;

	/** The region code. */
	private String regionCode;

	/** The vcpu. */
	private String vcpu;

	/** The country. */
	private String country;
	
	/** The company. */
	private String company;

	/** The ram. */
	private String ram;

	/** The storage. */
	private String storage;

	/** The region. */
	private String region;

	/** The cpu. */
	private String cpu;

	/** The instance. */
	private String instance;

	/** The continent. */
	private String continent;

	/** The memory. */
	private String memory;

	/** The gpu. */
	private String gpu;

	@JsonProperty("gpuCore")
	private String gpuCore;
	
	/** The logo. */
	private String logo;

	/** The instance type. */
	private String instanceType;

	/** The spot pricing. */
	private List<Object> spotPricing = null;

	/** The normal pricing. */
	private List<NormalPricing> normalPricing = null;

	/** The preemptive pricing. */
	private List<Object> preemptivePricing = null;

}
