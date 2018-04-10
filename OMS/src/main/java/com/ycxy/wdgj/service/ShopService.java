/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.service;

import java.util.List;

import com.ycxy.wdgj.dto.OptionDto;
import com.ycxy.wdgj.dto.PageInfo;
import com.ycxy.wdgj.model.Shop;

/**
 * @since 2018年2月23日 下午4:51:52
 * @author hjl
 *
 */
public interface ShopService {

    /**
     * @param shop
     */
    void add(Shop shop) throws Exception;

    /***
     * 查询店铺列表
     * 
     * @param pageInfo
     * @return
     */
    List<Shop> list(PageInfo pageInfo);

    /**
     * @param shopId
     * @return
     */
    Shop detail(Long shopId);

    /**
     * 查看本月销售额
     * 
     * @return
     */
    OptionDto count();

    List<Shop> findShopList(Long userId);
}
