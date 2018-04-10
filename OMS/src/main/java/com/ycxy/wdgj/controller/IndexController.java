/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ycxy.wdgj.common.utils.JSONUtils;
import com.ycxy.wdgj.common.utils.KdniaoUtils;
import com.ycxy.wdgj.dto.RequestData;

/**
 * @since 2018年2月12日 下午4:00:09
 * @author hjl
 *
 */
@RestController
@RequestMapping("/index")
public class IndexController {
    @GetMapping("/totest")
    public String toModule() throws Exception {
        String result = KdniaoUtils.getExpRecommendByJson(null);
        return result;
    }

    @GetMapping("/test")
    public String test() throws Exception {
        String requestData = "{'OrderCode': '012657700387'," + "'ShipperCode':'SF'," + "'PayType':1," + "'ExpType':1," + "'Cost':1.0," + "'OtherCost':1.0,"
                + "'Sender':" + "{"
                + "'Company':'LV','Name':'Taylor','Mobile':'15018442396','ProvinceName':'上海','CityName':'上海','ExpAreaName':'青浦区','Address':'明珠路73号'},"
                + "'Receiver':" + "{"
                + "'Company':'GCCUI','Name':'Yann','Mobile':'15018442396','ProvinceName':'北京','CityName':'北京','ExpAreaName':'朝阳区','Address':'三里屯街道雅秀大厦'},"
                + "'Commodity':" + "[{" + "'GoodsName':'鞋子','Goodsquantity':1,'GoodsWeight':1.0}]," + "'Weight':1.0," + "'Quantity':1," + "'Volume':0.0,"
                + "'Remark':'小心轻放'," + "'IsReturnPrintTemplate':1}";
        ObjectMapper objectMapper = new ObjectMapper();
        RequestData data = JSONUtils.converStrToObject(requestData, RequestData.class);
        return KdniaoUtils.orderOnlineByJson(data);
    }
}
