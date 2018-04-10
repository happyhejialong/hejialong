/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycxy.wdgj.common.exception.OmsException;
import com.ycxy.wdgj.common.utils.IdMakerUtils;
import com.ycxy.wdgj.common.utils.LimitClauseUtils;
import com.ycxy.wdgj.common.utils.ObjectUtils;
import com.ycxy.wdgj.dao.CustomerMapper;
import com.ycxy.wdgj.dto.PageInfo;
import com.ycxy.wdgj.model.Customer;
import com.ycxy.wdgj.model.CustomerExample;
import com.ycxy.wdgj.service.CustomerService;

/**
 * @since 2018年2月23日 下午1:53:45
 * @author hjl
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    /***
     * 分页查询客户档案列表
     * 
     * @param pageInfo
     *            分页信息
     * @throws OmsException
     */
    @Override
    public List<Customer> list(PageInfo pageInfo) throws OmsException {
        CustomerExample example = new CustomerExample();
        example.setLimitByClause(LimitClauseUtils.limit(pageInfo.getPageIndex(), pageInfo.getPageSize()));
        List<Customer> customerList = customerMapper.selectByExample(example);
        if (ObjectUtils.isEmpty(customerList)) {
            throw new OmsException("客户档案表为空");
        }
        return customerList;
    }

    /****
     * 添加客户档案
     * 
     * @param customer
     * @throws Exception
     */
    @Override
    public void add(Customer customer) throws Exception {
        customer.setCustomerId(IdMakerUtils.makeUniqueLong());
        int insertCustomerFlag = customerMapper.insertSelective(customer);
        if (insertCustomerFlag != 1) {
            throw new OmsException("添加客户失败:添加记录不为1");
        }
    }

}
