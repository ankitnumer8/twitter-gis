package com.qresq.twitter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The Class PdfDTO.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GitRepoDTO extends CommonDTO {

    /** The url. */
    private String url;

    /** The repo. */
    private String repo;

    /** The readme. */
    private String readme;

    /** The user. */
    private String user;

}
