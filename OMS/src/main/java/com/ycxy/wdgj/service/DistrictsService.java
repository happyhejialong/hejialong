/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.service;

import java.util.List;

import com.ycxy.wdgj.model.Districts;

/**
 * @since 2018年2月22日 上午10:29:01
 * @author hjl
 *
 */
public interface DistrictsService {

    /**
     * @param keyword
     * @return
     */
    List<Districts> findDistricts(String keyword) throws Exception;

}
