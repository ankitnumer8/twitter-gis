package com.qresq.twitter.service.response;

import com.qresq.twitter.dto.CommonDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class GitRepoResponse extends CommonDTO {

	/** The url. */
    private String url;

    /** The repo. */
    private String repo;
    
    /** The git hub url. */
    private String gitHubUrl;

    /** The user. */
    private String user;

}
