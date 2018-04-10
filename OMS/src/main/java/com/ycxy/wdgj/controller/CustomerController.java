/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ycxy.wdgj.common.OmsResponse;
import com.ycxy.wdgj.dto.PageInfo;
import com.ycxy.wdgj.model.Customer;
import com.ycxy.wdgj.service.CustomerService;

/**
 * @since 2018年2月23日 下午1:50:29
 * @author hjl
 *
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    /***
     * 查询客户档案列表
     * 
     * @param jsonStr
     *            用来存放条件
     * @param pageInfo
     * @return
     */
    @PostMapping("/list")
    public OmsResponse<List<Customer>> list(String jsonStr, PageInfo pageInfo) {
        OmsResponse<List<Customer>> or = new OmsResponse<List<Customer>>();
        try {
            List<Customer> customerList = customerService.list(pageInfo);
            or.getResult().setData(customerList);
        } catch (Exception e) {
            e.printStackTrace();
            or.setCode(e.hashCode());
            or.setMsg(e.getMessage());
        }
        return or;
    }

    /****
     * 添加客户档案
     * 
     * @param customer
     * @return
     */
    @PostMapping("/add")
    public OmsResponse<Object> add(Customer customer) {
        OmsResponse<Object> or = new OmsResponse<Object>();
        try {
            customerService.add(customer);
        } catch (Exception e) {
            e.printStackTrace();
            or.setCode(e.hashCode());
            or.setMsg(e.getMessage());
        }
        return or;
    }
}
