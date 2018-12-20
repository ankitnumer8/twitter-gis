package com.qresq.twitter.model;

import java.util.List;

import com.qresq.twitter.dto.CommonDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Instantiates a new author.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AuthorTagDetails extends CommonDTO{

	private List<TagDetails> tags;
}
