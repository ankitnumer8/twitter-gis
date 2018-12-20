package com.qresq.twitter.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Class PdfDTO.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PdfDTO extends CommonDTO {

    /** The doc id. */
    private String arxivId;

    /** The url. */
    private String url;

    /** The title. */
    private String title;

    /** The highlight content. */
    private String highlightContent;
}
