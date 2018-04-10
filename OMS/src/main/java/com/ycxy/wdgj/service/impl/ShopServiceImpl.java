/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycxy.wdgj.common.exception.OmsException;
import com.ycxy.wdgj.common.utils.CalendarUtils;
import com.ycxy.wdgj.common.utils.CollectionUtils;
import com.ycxy.wdgj.common.utils.IdMakerUtils;
import com.ycxy.wdgj.common.utils.LimitClauseUtils;
import com.ycxy.wdgj.common.utils.ObjectUtils;
import com.ycxy.wdgj.dao.ShopMapper;
import com.ycxy.wdgj.dto.OptionDto;
import com.ycxy.wdgj.dto.OptionDto.Series;
import com.ycxy.wdgj.dto.PageInfo;
import com.ycxy.wdgj.model.Shop;
import com.ycxy.wdgj.model.ShopExample;
import com.ycxy.wdgj.service.ShopService;

/**
 * @since 2018年2月23日 下午4:52:09
 * @author hjl
 *
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopMapper shopMapper;

    /***
     * 添加店铺
     * 
     * @param shop
     *            店铺基本信息
     * @throws Exception
     */
    @Override
    public void add(Shop shop) throws Exception {
        shop.setShopId(IdMakerUtils.makeUniqueLong());
        int insertShopFlag = shopMapper.insertSelective(shop);
        if (insertShopFlag != 1) {
            throw new OmsException("新增商铺失败：新增记录不为1");
        }
    }

    /****
     * 查看店铺列表
     */
    @Override
    public List<Shop> list(PageInfo pageInfo) {
        ShopExample example = new ShopExample();
        if (pageInfo.getPageIndex() != null && pageInfo.getPageSize() != null) {
            example.setLimitByClause(LimitClauseUtils.limit(pageInfo.getPageIndex(), pageInfo.getPageSize()));
        }
        return shopMapper.selectByExample(example);
    }

    /****
     * 通过主键查找shop
     */
    @Override
    public Shop detail(Long shopId) {
        ShopExample example = new ShopExample();
        example.createCriteria().andShopIdEqualTo(shopId);
        example.setLimitByClause(LimitClauseUtils.limit(0, 1));
        return CollectionUtils.getFirst(shopMapper.selectByExample(example));
    }

    /****
     * 查看店铺本月的销售额
     */
    @Override
    public OptionDto count() {
        OptionDto optionDto = new OptionDto();
        List<Shop> shopList = findShopList(123455L);
        if (!ObjectUtils.isEmpty(optionDto)) {
            List<Series> series = new ArrayList<Series>();
            int days = CalendarUtils.getDayOfMonth(new Date());
            for (int i = 0; i < shopList.size(); i++) {
                Series serie = new Series();
                serie.setName(shopList.get(i).getShopName());
                Double totalMoney = shopMapper.selectCountMoney(shopList.get(i).getShopId(), days);
                serie.setValue(ObjectUtils.isEmpty(totalMoney) ? 0 : totalMoney);
                series.add(serie);
            }
            optionDto.setSeries(series);
        }

        return optionDto;
    }

    /***
     * // 通过userId查询对应的店铺信息
     * 
     * @param userId
     * @return
     */
    @Override
    public List<Shop> findShopList(Long userId) {
        ShopExample example = new ShopExample();
        // example.createCriteria().andUserIdEqualTo(value);
        List<Shop> shopList = shopMapper.selectByExample(example);
        return shopList;
    }

}
