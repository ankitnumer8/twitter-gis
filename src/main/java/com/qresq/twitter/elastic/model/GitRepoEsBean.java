package com.qresq.twitter.elastic.model;

import com.qresq.twitter.elastic.core.EsBean;

/**
 * The Class GitRepoEsBean.
 */
public class GitRepoEsBean extends EsBean {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    /** The Constant EVENT_INDEX. */
    public static final String GITREPO_INDEX = "gitrepo_index";

    /** The Constant EVENT_DOCTYPE. */
    public static final String GITREPO_DOC_TYPE = "gitrepo_index";

    /** The _id. */
    private String _id;

    /** The url. */
    private String url;

    /** The repo. */
    private String repo;

    /** The readme. */
    private String readme;

    /** The user. */
    private String user;

    // Getter Methods

    /**
     * Gets the _id.
     *
     * @return the _id
     */
    public String get_id() {
        return _id;
    }

    /**
     * Gets the url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Gets the repo.
     *
     * @return the repo
     */
    public String getRepo() {
        return repo;
    }

    /**
     * Gets the readme.
     *
     * @return the readme
     */
    public String getReadme() {
        return readme;
    }

    /**
     * Gets the user.
     *
     * @return the user
     */
    public String getUser() {
        return user;
    }

    // Setter Methods

    /**
     * Sets the _id.
     *
     * @param _id the new _id
     */
    public void set_id(String _id) {
        this._id = _id;
    }

    /**
     * Sets the url.
     *
     * @param url the new url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Sets the repo.
     *
     * @param repo the new repo
     */
    public void setRepo(String repo) {
        this.repo = repo;
    }

    /**
     * Sets the readme.
     *
     * @param readme the new readme
     */
    public void setReadme(String readme) {
        this.readme = readme;
    }

    /**
     * Sets the user.
     *
     * @param user the new user
     */
    public void setUser(String user) {
        this.user = user;
    }
}
