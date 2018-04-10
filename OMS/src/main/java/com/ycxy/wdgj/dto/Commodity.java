/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.dto;

/**
 * @since 2018年2月23日 上午11:02:58
 * @author hjl
 *
 */
public class Commodity {
    // 商品名称
    private String GoodsName;
    // 商品价格
    private Double GoodsPrice;
    // 商品描述
    private String GoodsDesc;
    // 商品体积m3
    private Double GoodsVol;
    private String GoodsCode;
    // 商品数量
    private Integer Goodsquantity;
    // 商品重量kg
    private Double GoodsWeight;

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    public Integer getGoodsquantity() {
        return Goodsquantity;
    }

    public void setGoodsquantity(Integer goodsquantity) {
        Goodsquantity = goodsquantity;
    }

    public Double getGoodsWeight() {
        return GoodsWeight;
    }

    public void setGoodsWeight(Double goodsWeight) {
        GoodsWeight = goodsWeight;
    }

    public Double getGoodsPrice() {
        return GoodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        GoodsPrice = goodsPrice;
    }

    public String getGoodsDesc() {
        return GoodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        GoodsDesc = goodsDesc;
    }

    public Double getGoodsVol() {
        return GoodsVol;
    }

    public void setGoodsVol(Double goodsVol) {
        GoodsVol = goodsVol;
    }

    public String getGoodsCode() {
        return GoodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        GoodsCode = goodsCode;
    }
}
