/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.service.impl;

import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ycxy.wdgj.common.HttpClientUtils;
import com.ycxy.wdgj.common.OmsConstant;
import com.ycxy.wdgj.common.exception.OmsException;
import com.ycxy.wdgj.common.utils.ObjectUtils;
import com.ycxy.wdgj.dao.DistrictsMapper;
import com.ycxy.wdgj.model.Districts;
import com.ycxy.wdgj.model.DistrictsExample;
import com.ycxy.wdgj.service.DistrictsService;

/**
 * @since 2018年2月22日 上午10:29:19
 * @author hjl
 *
 */
@Service
public class DistrictsServiceImpl implements DistrictsService {
    @Autowired
    private DistrictsMapper districtsMapper;
    private static ObjectMapper objectMapper = new ObjectMapper();

    /***
     * 通过关键字查询下一级的行政区域
     * 
     * @param keyword
     *            关键字
     * @throws Exception
     */
    @Override
    public List<Districts> findDistricts(String keyword) throws Exception {
        // 先从数据库中获取
        List<Districts> districts = findDistrictsByDB(keyword);
        if (!ObjectUtils.isEmpty(districts)) {
            return districts;
        }
        // 若无从高德官网获取
        districts = findDistrictsByAMAP(keyword);
        return districts;
    }

    /**
     * 通过高德官网获取
     * 
     * @param keyword
     *            关键字
     * @throws Exception
     * 
     */
    public List<Districts> findDistrictsByAMAP(String keyword) throws Exception {
        String uri = OmsConstant.AMAP_URI + "&keywords=" + URLEncoder.encode(keyword, "UTF-8") + "&key=" + OmsConstant.AMAP_KEY;
        String result = HttpClientUtils.doHttpGet(uri);
        JsonNode jsonNode = objectMapper.readTree(result).get("districts").get(0).path("districts");
        List<Districts> districts = objectMapper.readValue(jsonNode.toString(), new TypeReference<List<Districts>>() {
        });
        int insertDistrictsListFlag = districtsMapper.insertSelectiveList(districts, keyword);
        if (insertDistrictsListFlag != districts.size()) {
            throw new OmsException("插入失败:插入总条数与实际条数不匹配");
        }
        return districts;
    }

    /***
     * 在数据库中获取
     * 
     * @param keyword
     * @return
     */
    public List<Districts> findDistrictsByDB(String keyword) {
        DistrictsExample example = new DistrictsExample();
        example.createCriteria().andKeywordEqualTo(keyword);
        List<Districts> districts = districtsMapper.selectByExample(example);
        return districts;
    }

}
