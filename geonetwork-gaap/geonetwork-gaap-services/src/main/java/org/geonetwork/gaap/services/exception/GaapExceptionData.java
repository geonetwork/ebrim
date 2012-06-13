package org.geonetwork.gaap.services.exception;

public class GaapExceptionData
{
    private String m_data;

    public GaapExceptionData() {}

    public GaapExceptionData(String data) {
        m_data = data;
    }

    public void setData(String data) {
        m_data = data;
    }

    public String getData() {
        return m_data;
    }
}