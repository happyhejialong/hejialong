package com.ycxy.wdgj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ycxy.wdgj.common.exception.OmsException;
import com.ycxy.wdgj.common.utils.IdMakerUtils;
import com.ycxy.wdgj.common.utils.LimitClauseUtils;
import com.ycxy.wdgj.common.utils.MathUtils;
import com.ycxy.wdgj.common.utils.ObjectUtils;
import com.ycxy.wdgj.dao.ProductMapper;
import com.ycxy.wdgj.dto.ConditionDto;
import com.ycxy.wdgj.dto.PageInfo;
import com.ycxy.wdgj.model.Product;
import com.ycxy.wdgj.model.ProductExample;
import com.ycxy.wdgj.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    /***
     * 通过条件查询订单
     * 
     * @param condition
     *            查询条件
     */
    @Override
    public List<Product> findAll(ConditionDto condition) {
        ProductExample example = new ProductExample();
        PageInfo pageInfo = condition.getPageInfo();
        example.createCriteria().andIsdeleteEqualTo((byte) 0);
        example.setLimitByClause(LimitClauseUtils.limit(pageInfo.getPageIndex(), pageInfo.getPageSize()));
        List<Product> productList = productMapper.selectByExample(example);
        return productList;
    }

    /***
     * 新增货品
     * 
     * @param product
     *            货品信息
     * @throws Exception
     */
    @Override
    public void add(Product product) throws Exception {
        // 如果货品id不是用户输入的话，自动生成
        if (StringUtils.isEmpty(product.getGoodsId())) {
            product.setGoodsId(IdMakerUtils.makeObjectId("prod"));
        }
        // 如果条码id不是用户输入的话，自动生成
        if (StringUtils.isEmpty(product.getBarcode())) {
            product.setBarcode(String.valueOf(MathUtils.getRandomNum6B()));
        }
        int insertProductFlag = productMapper.insert(product);
        if (insertProductFlag != 1) {
            throw new OmsException("新增失败，新增记录数不为1");
        }
    }

    /***
     * 逻辑 删除勾选的货品们
     * 
     * @param ids
     * @throws Exception
     */
    @Override
    public void delete(List<Integer> ids) throws Exception {
        if (ObjectUtils.isEmpty(ids)) {
            throw new OmsException("请勾选好订单");
        }
        productMapper.updateIsDeleteByPrimaryKeyList(ids);
    }

}
