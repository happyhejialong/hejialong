package com.ycxy.wdgj.dao;

import com.ycxy.wdgj.model.TradeCustomer;
import com.ycxy.wdgj.model.TradeCustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeCustomerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_customer_tb
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    long countByExample(TradeCustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_customer_tb
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    int deleteByExample(TradeCustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_customer_tb
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_customer_tb
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    int insert(TradeCustomer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_customer_tb
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    int insertSelective(TradeCustomer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_customer_tb
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    List<TradeCustomer> selectByExample(TradeCustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_customer_tb
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    TradeCustomer selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_customer_tb
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    int updateByExampleSelective(@Param("record") TradeCustomer record, @Param("example") TradeCustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_customer_tb
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    int updateByExample(@Param("record") TradeCustomer record, @Param("example") TradeCustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_customer_tb
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    int updateByPrimaryKeySelective(TradeCustomer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_customer_tb
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    int updateByPrimaryKey(TradeCustomer record);
}