package org.geonetwork.domain.csw202.discovery;

/**
 * @author heikki doeleman
 */
public enum ResultType {

    /**
     * Include results in the response.
     */
    results,
    /**
     * Provide a result set summary, but no results.
     */
    hits,
    /**
     * Validate the request and return an Acknowledgement message if it is valid. Continue
     * processing the request asynchronously.
     */
    validate
}