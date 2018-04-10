/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.ycxy.wdgj.common.OmsResponse;
import com.ycxy.wdgj.common.utils.JSONUtils;
import com.ycxy.wdgj.dto.ConditionDto;
import com.ycxy.wdgj.dto.OptionDto;
import com.ycxy.wdgj.dto.SrcDestTradeGoodsDto;
import com.ycxy.wdgj.dto.TradeOrderDto;
import com.ycxy.wdgj.model.Shop;
import com.ycxy.wdgj.model.TradeGoods;
import com.ycxy.wdgj.model.TradeOrder;
import com.ycxy.wdgj.model.User;
import com.ycxy.wdgj.service.TradeOrderService;
import com.ycxy.wdgj.taobao.request.TradesSoldGetRequest;

/**
 * @since 2018年2月12日 上午11:29:07
 * @author hjl
 *
 */
@RestController
@RequestMapping("/trade")
public class TradeOrderController {
    @Autowired
    private TradeOrderService tradeOrderService;

    @PostMapping("/add")
    public OmsResponse<Object> add(String jsonStr, HttpSession session) {
        OmsResponse<Object> or = new OmsResponse<Object>();
        try {
            User user = (User) session.getAttribute("user");
            TradeOrderDto tradeOrderDto = JSONUtils.converStrToObject(jsonStr, TradeOrderDto.class);
            // tradeOrderDto.getTradeOrder().setUserId(user.getId());
            tradeOrderService.add(tradeOrderDto);
        } catch (Exception e) {
            e.printStackTrace();
            or.setCode(e.hashCode());
            or.setMsg("订单新增失败，失败原因:" + e.getMessage());
        }
        return or;
    }

    /***
     * 查询订单详情
     * 
     * @param id
     *            订单流水id
     * @return
     */
    @GetMapping("/detail")
    public OmsResponse<TradeOrderDto> detail(Integer id) {
        OmsResponse<TradeOrderDto> or = new OmsResponse<TradeOrderDto>();
        try {
            TradeOrderDto tradeOrderDto = tradeOrderService.findAll(id);
            or.getResult().setData(tradeOrderDto);
        } catch (Exception e) {
            or.setCode(e.hashCode());
            or.setMsg("查询订单详情失败:" + e.getMessage());
        }
        return or;
    }

    /***
     * 删除订单
     * 
     * param id 订单流水id
     * 
     */
    @GetMapping("/delete")
    public OmsResponse<Object> delete(Integer id) {
        OmsResponse<Object> or = new OmsResponse<Object>();
        try {
            tradeOrderService.delete(id);
        } catch (Exception e) {
            or.setCode(e.hashCode());
            or.setMsg("删除订单失败:" + e.getMessage());
        }
        return or;
    }

    @PostMapping("/list")
    public OmsResponse<List<TradeOrder>> list(String jsonStr) {
        OmsResponse<List<TradeOrder>> or = new OmsResponse<List<TradeOrder>>();
        try {
            ConditionDto conditionDto = JSONUtils.converStrToObject(jsonStr, ConditionDto.class);
            if (conditionDto == null) {
                conditionDto = new ConditionDto();
            }
            List<TradeOrder> tradeOrderList = tradeOrderService.list(conditionDto);
            or.getResult().setData(tradeOrderList);
        } catch (Exception e) {
            e.printStackTrace();
            or.setCode(e.hashCode());
            or.setMsg(e.getMessage());
        }
        return or;
    }

    @GetMapping("/verify")
    public OmsResponse<Object> verify(Integer[] ids) {
        OmsResponse<Object> or = new OmsResponse<Object>();
        try {
            tradeOrderService.verify(ids);
        } catch (Exception e) {
            e.printStackTrace();
            or.setCode(e.hashCode());
            or.setMsg(e.getMessage());
        }
        return or;
    }

    /****
     * 发货确认
     * 
     * @param tradeId
     *            主订单号
     * @return
     */
    @GetMapping("/send")
    public OmsResponse<Object> send(Long tradeId, Double postFee) {
        OmsResponse<Object> or = new OmsResponse<Object>();
        try {
            tradeOrderService.send(tradeId, postFee);
        } catch (Exception e) {
            e.printStackTrace();
            or.setCode(e.hashCode());
            or.setMsg(e.getMessage());
        }
        return or;
    }

    /****
     * 通过主订单id获取主订单信息
     * 
     * @param tradeId
     *            主订单号
     * @return
     */
    @GetMapping("/getTradeOrder")
    public OmsResponse<TradeOrder> getTradeOrder(Long tradeId) {
        OmsResponse<TradeOrder> or = new OmsResponse<TradeOrder>();
        try {
            TradeOrder tradeOrder = tradeOrderService.findTradeOrderByTradeId(tradeId);
            or.getResult().setData(tradeOrder);
        } catch (Exception e) {
            e.printStackTrace();
            or.setCode(e.hashCode());
            or.setMsg(e.getMessage());
        }
        return or;
    }

    /****
     * 订单下载
     */
    @PostMapping("/install")
    public OmsResponse<Shop> tradesSoldGet(Shop shop, TradesSoldGetRequest request) {
        OmsResponse<Shop> or = new OmsResponse<Shop>();
        try {
            tradeOrderService.install(shop, request);
        } catch (Exception e) {
            e.printStackTrace();
            or.setCode(e.hashCode());
            or.setMsg(e.getMessage());
        }
        return or;
    }

    /****
     * 查询订单下的所有订单货品列表
     */
    @GetMapping("/getTradeGoods")
    public OmsResponse<List<TradeGoods>> getTradeGoods(Long tradeId) {
        OmsResponse<List<TradeGoods>> or = new OmsResponse<List<TradeGoods>>();
        try {
            List<TradeGoods> tradeGoodsArr = tradeOrderService.findTradeGoodsArrByTradeId(tradeId);
            or.getResult().setData(tradeGoodsArr);
        } catch (Exception e) {
            e.printStackTrace();
            or.setCode(e.hashCode());
            or.setMsg(e.getMessage());
        }
        return or;
    }

    /****
     * 订单拆分
     * 
     * @param srcDestTradeGoodsArrDto
     */
    @PostMapping("/split")
    public OmsResponse<Object> split(String jsonStr) {
        OmsResponse<Object> or = new OmsResponse<Object>();
        try {
            SrcDestTradeGoodsDto srcDestTradeGoodsDto = JSON.parseObject(jsonStr, SrcDestTradeGoodsDto.class);
            tradeOrderService.split(srcDestTradeGoodsDto);
        } catch (Exception e) {
            e.printStackTrace();
            or.setCode(e.hashCode());
            or.setMsg(e.getMessage());
        }
        return or;
    }

    /***
     * 订单合并
     * 
     * @param
     */
    @GetMapping("/merge")
    public OmsResponse<Object> merge(Integer[] ids) {
        OmsResponse<Object> or = new OmsResponse<Object>();
        try {
            tradeOrderService.merge(ids);
        } catch (Exception e) {
            e.printStackTrace();
            or.setCode(e.hashCode());
            or.setMsg(e.getMessage());
        }
        return or;
    }

    /***
     * 查询当前一个礼拜的销售情况
     */
    @GetMapping("/count")
    public OmsResponse<OptionDto> count() {
        OmsResponse<OptionDto> or = new OmsResponse<OptionDto>();
        try {
            OptionDto optionDto = tradeOrderService.count();
            or.getResult().setData(optionDto);
        } catch (Exception e) {
            e.printStackTrace();
            or.setCode(e.hashCode());
            or.setMsg(e.getMessage());
        }
        return or;
    }
   
}
