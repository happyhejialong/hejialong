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

import com.ycxy.wdgj.common.OmsResponse;
import com.ycxy.wdgj.dto.OptionDto;
import com.ycxy.wdgj.dto.PageInfo;
import com.ycxy.wdgj.model.Shop;
import com.ycxy.wdgj.service.ShopService;

/**
 * @since 2018年2月23日 下午4:48:01
 * @author hjl
 *
 */
@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @PostMapping("/add")
    public OmsResponse<Object> add(Shop shop, HttpSession session) {
        OmsResponse<Object> or = new OmsResponse<Object>();
        try {
            shopService.add(shop);
        } catch (Exception e) {
            e.printStackTrace();
            or.setCode(e.hashCode());
            or.setMsg("店铺添加失败:" + e.getMessage());
        }
        return or;
    }

    @GetMapping("/list")
    public OmsResponse<List<Shop>> list(PageInfo pageInfo) {
        OmsResponse<List<Shop>> or = new OmsResponse<List<Shop>>();
        try {
            List<Shop> shopList = shopService.list(pageInfo);
            or.getResult().setData(shopList);
        } catch (Exception e) {
            e.printStackTrace();
            or.setCode(e.hashCode());
            or.setMsg(e.getMessage());
        }
        return or;
    }

    /****
     * 查看店铺本月的销售额
     */
    @GetMapping("/count")
    public OmsResponse<OptionDto> count() {
        OmsResponse<OptionDto> or = new OmsResponse<OptionDto>();
        try {
            OptionDto option = shopService.count();
            or.getResult().setData(option);
        } catch (Exception e) {
            e.printStackTrace();
            or.setCode(e.hashCode());
            or.setMsg(e.getMessage());
        }
        return or;
    }
}
