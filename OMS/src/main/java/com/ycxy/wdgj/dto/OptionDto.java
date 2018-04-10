/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 2018年3月7日 下午5:08:16
 * @author hjl
 *
 */
public class OptionDto {
    private String[] xAxisData;
    private List<Series> series = new ArrayList<Series>();

    public static class Series {
        private String name;
        private Double value;
        private Double[] totalMoney;

        public Double getValue() {
            return value;
        }

        public void setValue(Double value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double[] getTotalMoney() {
            return totalMoney;
        }

        public void setTotalMoney(Double[] totalMoney) {
            this.totalMoney = totalMoney;
        }

    }

    public String[] getxAxisData() {
        return xAxisData;
    }

    public void setxAxisData(String[] xAxisData) {
        this.xAxisData = xAxisData;
    }

    public List<Series> getSeries() {
        return series;
    }

    public void setSeries(List<Series> series) {
        this.series = series;
    }

}
