package com.ycxy.wdgj.dao;

import com.ycxy.wdgj.model.Customer;
import com.ycxy.wdgj.model.CustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crustomer_tb
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    long countByExample(CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crustomer_tb
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    int deleteByExample(CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crustomer_tb
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crustomer_tb
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    int insert(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crustomer_tb
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    int insertSelective(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crustomer_tb
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    List<Customer> selectByExample(CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crustomer_tb
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    Customer selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crustomer_tb
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crustomer_tb
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crustomer_tb
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    int updateByPrimaryKeySelective(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crustomer_tb
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    int updateByPrimaryKey(Customer record);
}