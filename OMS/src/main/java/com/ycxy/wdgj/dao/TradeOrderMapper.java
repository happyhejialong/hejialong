package com.ycxy.wdgj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ycxy.wdgj.model.TradeOrder;
import com.ycxy.wdgj.model.TradeOrderExample;



public interface TradeOrderMapper {

    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trade_order
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	long countByExample(TradeOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trade_order
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	int deleteByExample(TradeOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trade_order
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trade_order
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	int insert(TradeOrder record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trade_order
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	int insertSelective(TradeOrder record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trade_order
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	List<TradeOrder> selectByExample(TradeOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trade_order
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	TradeOrder selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trade_order
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	int updateByExampleSelective(@Param("record") TradeOrder record, @Param("example") TradeOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trade_order
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	int updateByExample(@Param("record") TradeOrder record, @Param("example") TradeOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trade_order
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	int updateByPrimaryKeySelective(TradeOrder record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table trade_order
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	int updateByPrimaryKey(TradeOrder record);

	/**
     * @param date
     * @param date2
     * @return
     */
    Double selectShopCount(@Param("days") int days, @Param("shopId") Long shopId);
}