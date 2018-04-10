/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @since 2018年2月22日 上午9:19:18
 * @author hjl
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trace {
    @JsonProperty("AcceptStation")
    private String acceptStation;
    @JsonProperty("AcceptTime")
    private String acceptTime;

    public String getAcceptStation() {
        return acceptStation;
    }

    public void setAcceptStation(String acceptStation) {
        this.acceptStation = acceptStation;
    }

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

}
