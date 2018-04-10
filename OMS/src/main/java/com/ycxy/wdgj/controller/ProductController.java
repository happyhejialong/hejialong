package com.ycxy.wdgj.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ycxy.wdgj.common.OmsResponse;
import com.ycxy.wdgj.common.utils.BindingResultHelper;
import com.ycxy.wdgj.dto.ConditionDto;
import com.ycxy.wdgj.dto.PageInfo;
import com.ycxy.wdgj.model.Product;
import com.ycxy.wdgj.service.ProductService;
import com.ycxy.wdgj.valid.insert;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /***
     * 分页查询货品档案
     * 
     * @param jsonStr
     * @return
     */
    @GetMapping("/findAll")
    public OmsResponse<List<Product>> findAll(String jsonStr, PageInfo pageInfo) {
        OmsResponse<List<Product>> or = new OmsResponse<List<Product>>();
        try {
            ConditionDto condition = new ConditionDto();
            condition.setPageInfo(pageInfo);
            // ConditionDto condition = JSONUtils.converStrToObject(jsonStr, ConditionDto.class);
            List<Product> productList = productService.findAll(condition);
            or.getResult().setData(productList);
        } catch (Exception e) {
            or.setCode(e.hashCode());
            or.setMsg(e.getMessage());
        }
        return or;
    }

    /***
     * 新增货品
     * 
     * @param jsonStr
     * @return
     */
    @PostMapping("/add")
    public OmsResponse<Object> add(@Validated(value = { insert.class }) Product product, BindingResult result) {
        OmsResponse<Object> or = new OmsResponse<Object>();
        try {
            BindingResultHelper.cacheExceptions(result);
            productService.add(product);
        } catch (Exception e) {
            e.printStackTrace();
            or.setCode(e.hashCode());
            or.setMsg(e.getMessage());
        }
        return or;
    }

    @GetMapping("/delete")
    public OmsResponse<Object> delete(Integer[] id) {
        OmsResponse<Object> or = new OmsResponse<Object>();
        try {
            productService.delete(Arrays.asList(id));
        } catch (Exception e) {
            e.printStackTrace();
            or.setCode(e.hashCode());
            or.setMsg(e.getMessage());
        }
        return or;
    }

}
