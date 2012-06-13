package org.geonetwork.gaap.domain.web.response;

import java.util.List;
import java.util.ArrayList;

/**
 * Parent class for Gaap responses
 */
public abstract class BaseResponse {
    ResponseStatusCode status;

    List<String> exceptionList;

    public BaseResponse() {
        this.status = ResponseStatusCode.OK;
    }

    public BaseResponse(ResponseStatusCode status) {
        this.status = status;
    }

    public ResponseStatusCode getStatus() {
        return status;
    }

    public void setStatus(ResponseStatusCode status) {
        this.status = status;
    }

    public List<String> getExceptionList() {
        return exceptionList;
    }

    public void setExceptionList(List<String> exceptionList) {
        this.exceptionList = exceptionList;
    }

    public void addException(String exception) {
        if (exceptionList == null) exceptionList = new ArrayList<String>();
        this.exceptionList.add(exception);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseResponse that = (BaseResponse) o;

        if (exceptionList != null ? !exceptionList.equals(that.exceptionList) : that.exceptionList != null)
            return false;
        if (status != that.status) return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;

        int result = status != null ? status.hashCode() : 0;
        result = prime * result + (exceptionList != null ? exceptionList.hashCode() : 0);
        return result;
    }
}
