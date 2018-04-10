/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 快递信息
 * 
 * @since 2018年2月23日 下午2:46:20
 * @author hjl
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Express {
    private String expCode;
    private String expName;
    private String liheName;
    private Double fee;
    private Double estimatedDeliveryTime;
    private Byte isSupport;
    private String remark;
    private Byte recommendReason;

    public String getExpCode() {
        return expCode;
    }

    public void setExpCode(String expCode) {
        this.expCode = expCode;
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public String getLiheName() {
        return liheName;
    }

    public void setLiheName(String liheName) {
        this.liheName = liheName;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Double getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(Double estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    public Byte getIsSupport() {
        return isSupport;
    }

    public void setIsSupport(Byte isSupport) {
        this.isSupport = isSupport;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getRecommendReason() {
        return recommendReason;
    }

    public void setRecommendReason(Byte recommendReason) {
        this.recommendReason = recommendReason;
    }

}
