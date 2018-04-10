/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @since 2018年2月22日 上午9:14:00
 * @author hjl
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LogisticsInfo {
    @JsonProperty("LogisticCode")
    private String logisticCode;
    @JsonProperty("ShipperCode")
    private String shipperCode;
    @JsonProperty("Traces")
    private List<Trace> traces;
    @JsonProperty("State")
    public Byte state;
    @JsonProperty("EBusinessID")
    public String EBusinessID;

    public String getLogisticCode() {
        return logisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        this.logisticCode = logisticCode;
    }

    public String getShipperCode() {
        return shipperCode;
    }

    public void setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
    }

    public List<Trace> getTraces() {
        return traces;
    }

    public void setTraces(List<Trace> traces) {
        this.traces = traces;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getEBusinessID() {
        return EBusinessID;
    }

    public void setEBusinessID(String eBusinessID) {
        EBusinessID = eBusinessID;
    }

}
