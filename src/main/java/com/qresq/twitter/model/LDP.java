package com.qresq.twitter.model;

import java.util.List;

import com.qresq.twitter.dto.CommonDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper =false)
public class LDP extends CommonDTO {
	
	/** The performer. */
	private List<Performer> performer;
	
	/** The name. */
	private String name;
	
	/** The location. */
	private Location location;
}
