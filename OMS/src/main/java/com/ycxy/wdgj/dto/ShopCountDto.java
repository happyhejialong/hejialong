/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.dto;

/**
 * @since 2018年3月7日 下午5:45:10
 * @author hjl
 *
 */
public class ShopCountDto {
    private String shopId;
    private String shopName;
    private String totalMoneys;
    private String gmtCreate;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getTotalMoneys() {
        return totalMoneys;
    }

    public void setTotalMoneys(String totalMoneys) {
        this.totalMoneys = totalMoneys;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

}
