/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.dto;

import java.util.List;

import com.ycxy.wdgj.model.TradeCustomer;
import com.ycxy.wdgj.model.TradeGoods;
import com.ycxy.wdgj.model.TradeOrder;
import com.ycxy.wdgj.model.TradeReceiver;

/**
 * @since 2018年2月12日 下午1:21:09
 * @author hjl
 *
 */
public class TradeOrderDto {
    // 前台传递的分页信息
    private PageInfo pageInfo;
    // 主订单信息
    private TradeOrder tradeOrder;
    // 订单交易客户信息
    private TradeCustomer tradeCustomer;
    // 订单收件人信息
    private TradeReceiver tradeReceiver;
    // 订单商品列表
    private List<TradeGoods> tradeGoodsArr;

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public TradeOrder getTradeOrder() {
        return tradeOrder;
    }

    public void setTradeOrder(TradeOrder tradeOrder) {
        this.tradeOrder = tradeOrder;
    }

    public TradeCustomer getTradeCustomer() {
        return tradeCustomer;
    }

    public void setTradeCustomer(TradeCustomer tradeCustomer) {
        this.tradeCustomer = tradeCustomer;
    }

    public TradeReceiver getTradeReceiver() {
        return tradeReceiver;
    }

    public void setTradeReceiver(TradeReceiver tradeReceiver) {
        this.tradeReceiver = tradeReceiver;
    }

    public List<TradeGoods> getTradeGoodsArr() {
        return tradeGoodsArr;
    }

    public void setTradeGoodsArr(List<TradeGoods> tradeGoodsArr) {
        this.tradeGoodsArr = tradeGoodsArr;
    }

}
