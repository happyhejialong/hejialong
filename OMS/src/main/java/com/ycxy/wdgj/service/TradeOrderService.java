/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.service;

import java.util.List;

import com.ycxy.wdgj.common.exception.OmsException;
import com.ycxy.wdgj.dto.ConditionDto;
import com.ycxy.wdgj.dto.OptionDto;
import com.ycxy.wdgj.dto.SrcDestTradeGoodsDto;
import com.ycxy.wdgj.dto.TradeOrderDto;
import com.ycxy.wdgj.model.Shop;
import com.ycxy.wdgj.model.TradeGoods;
import com.ycxy.wdgj.model.TradeOrder;
import com.ycxy.wdgj.taobao.request.TradesSoldGetRequest;

/**
 * @since 2018年2月12日 下午1:19:37
 * @author hjl
 *
 */
public interface TradeOrderService {

    /**
     * 新增订单
     * 
     * @param tradeOrderDto
     *            订单所有信息
     */
    void add(TradeOrderDto tradeOrderDto) throws Exception;

    /**
     * 通过流水id查询订单详情
     * 
     * @param id
     *            订单流水id
     * @return
     */
    TradeOrderDto findAll(Integer id) throws Exception;

    void delete(Integer id) throws OmsException;

    List<TradeOrder> list(ConditionDto conditionDto);

    /***
     * 订单审核
     * 
     * @param id
     * 
     */
    void verify(Integer[] id) throws Exception;

    /**
     * 发货确认
     * 
     * @param tradeId
     */
    void send(Long tradeId, Double PostFee) throws Exception;

    /**
     * 通过主订单号来查询订单信息
     * 
     * @param tradeId
     *            主订单号
     * @throws OmsException
     */
    public TradeOrder findTradeOrderByTradeId(Long tradeId) throws Exception;

    /****
     * 下载淘系订单
     * 
     * @param shop
     */
    void install(Shop shop, TradesSoldGetRequest request) throws Exception;

    /**
     * @param tradeId
     * @return
     */
    List<TradeGoods> findTradeGoodsArrByTradeId(Long tradeId) throws Exception;

    /**
     * 订单拆分
     * 
     * @param srcDestTradeGoodsDto
     */
    void split(SrcDestTradeGoodsDto srcDestTradeGoodsDto) throws Exception;

    /**
     * @param ids
     */
    void merge(Integer[] ids) throws Exception;

    /**
     * @return
     */
    OptionDto count();
}
