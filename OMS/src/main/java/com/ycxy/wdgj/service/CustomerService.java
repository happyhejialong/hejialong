/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.service;

import java.util.List;

import com.ycxy.wdgj.common.exception.OmsException;
import com.ycxy.wdgj.dto.PageInfo;
import com.ycxy.wdgj.model.Customer;

/**
 * @since 2018年2月23日 下午1:53:33
 * @author hjl
 *
 */
public interface CustomerService {

    /**
     * @param pageInfo
     * @return
     */
    List<Customer> list(PageInfo pageInfo) throws OmsException;

    /**
     * 添加客户
     * 
     * @param customer
     */
    void add(Customer customer) throws Exception;

}
