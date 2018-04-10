package com.ycxy.wdgj.dao;

import com.ycxy.wdgj.model.TradeGoods;
import com.ycxy.wdgj.model.TradeGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeGoodsMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table trade_goods
     * @mbg.generated  Fri Feb 23 09:36:54 CST 2018
     */
    long countByExample(TradeGoodsExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table trade_goods
     * @mbg.generated  Fri Feb 23 09:36:54 CST 2018
     */
    int deleteByExample(TradeGoodsExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table trade_goods
     * @mbg.generated  Fri Feb 23 09:36:54 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table trade_goods
     * @mbg.generated  Fri Feb 23 09:36:54 CST 2018
     */
    int insert(TradeGoods record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table trade_goods
     * @mbg.generated  Fri Feb 23 09:36:54 CST 2018
     */
    int insertSelective(TradeGoods record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table trade_goods
     * @mbg.generated  Fri Feb 23 09:36:54 CST 2018
     */
    List<TradeGoods> selectByExample(TradeGoodsExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table trade_goods
     * @mbg.generated  Fri Feb 23 09:36:54 CST 2018
     */
    TradeGoods selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table trade_goods
     * @mbg.generated  Fri Feb 23 09:36:54 CST 2018
     */
    int updateByExampleSelective(@Param("record") TradeGoods record, @Param("example") TradeGoodsExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table trade_goods
     * @mbg.generated  Fri Feb 23 09:36:54 CST 2018
     */
    int updateByExample(@Param("record") TradeGoods record, @Param("example") TradeGoodsExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table trade_goods
     * @mbg.generated  Fri Feb 23 09:36:54 CST 2018
     */
    int updateByPrimaryKeySelective(TradeGoods record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table trade_goods
     * @mbg.generated  Fri Feb 23 09:36:54 CST 2018
     */
    int updateByPrimaryKey(TradeGoods record);
}