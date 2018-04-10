package com.ycxy.wdgj.service;

import java.util.List;

import com.ycxy.wdgj.dto.ConditionDto;
import com.ycxy.wdgj.model.Product;

public interface ProductService {

    List<Product> findAll(ConditionDto condition);

    /**
     * 新增货品
     * 
     * @param product
     *            货品信息
     */
    void add(Product product) throws Exception;

    /**
     * 删除订单
     * 
     * @param ids
     */
    void delete(List<Integer> ids) throws Exception;

}
