/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ycxy.wdgj.common.OmsResponse;
import com.ycxy.wdgj.model.Districts;
import com.ycxy.wdgj.service.DistrictsService;

/**
 * @since 2018年2月22日 上午10:24:26
 * @author hjl
 *
 */
@RestController
@RequestMapping("/districts")
public class DistrictsController {
    @Autowired
    private DistrictsService districtsService;

    /***
     * 通过关键字查询下一级的行政区域
     * 
     * @param keyword
     *            关键字
     * @return
     */
    @GetMapping("/findDistricts/{keyword}")
    public OmsResponse<List<Districts>> findDistricts(@PathVariable String keyword) {
        OmsResponse<List<Districts>> or = new OmsResponse<List<Districts>>();
        try {
            List<Districts> districts = districtsService.findDistricts(keyword);
            or.getResult().setData(districts);
        } catch (Exception e) {
            e.printStackTrace();
            or.setCode(e.hashCode());
            or.setMsg("查询行政区域失败:" + e.getMessage());
        }
        return or;
    }
}
