package com.ycxy.wdgj.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
    /**
     *
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * crustomer_tb.id
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * crustomer_tb.customer_id
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    private Long customerId;

    /**
     *
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * crustomer_tb.customer_type
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    private Byte customerType;

    /**
     *
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * crustomer_tb.customer_level
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    private Byte customerLevel;

    /**
     *
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * crustomer_tb.customer_nick
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    private String customerNick;

    /**
     *
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * crustomer_tb.customer_name
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    private String customerName;

    /**
     *
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * crustomer_tb.phone
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * crustomer_tb.country
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    private String country;

    /**
     *
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * crustomer_tb.state
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    private String state;

    /**
     *
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * crustomer_tb.city
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    private String city;

    /**
     *
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * crustomer_tb.district
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    private String district;

    /**
     *
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * crustomer_tb.address
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * crustomer_tb.zip
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    private String zip;

    /**
     *
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * crustomer_tb.email
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * crustomer_tb.qq
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    private String qq;

    /**
     *
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * crustomer_tb.gender
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    private Byte gender;

    /**
     *
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * crustomer_tb.birthday
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    private Date birthday;

    /**
     *
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * crustomer_tb.age
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    private Integer age;

    /**
     *
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * crustomer_tb.gmt_created
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    private Date gmtCreated;

    /**
     *
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * crustomer_tb.gmt_modified
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    private Date gmtModified;

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column crustomer_tb.id
     *
     * @return the value of crustomer_tb.id
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column crustomer_tb.id
     *
     * @param id
     *            the value for crustomer_tb.id
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column crustomer_tb.customer_id
     *
     * @return the value of crustomer_tb.customer_id
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column crustomer_tb.customer_id
     *
     * @param customerId
     *            the value for crustomer_tb.customer_id
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column crustomer_tb.customer_type
     *
     * @return the value of crustomer_tb.customer_type
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public Byte getCustomerType() {
        return customerType;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column crustomer_tb.customer_type
     *
     * @param customerType
     *            the value for crustomer_tb.customer_type
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public void setCustomerType(Byte customerType) {
        this.customerType = customerType;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column crustomer_tb.customer_level
     *
     * @return the value of crustomer_tb.customer_level
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public Byte getCustomerLevel() {
        return customerLevel;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column crustomer_tb.customer_level
     *
     * @param customerLevel
     *            the value for crustomer_tb.customer_level
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public void setCustomerLevel(Byte customerLevel) {
        this.customerLevel = customerLevel;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column crustomer_tb.customer_nick
     *
     * @return the value of crustomer_tb.customer_nick
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public String getCustomerNick() {
        return customerNick;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column crustomer_tb.customer_nick
     *
     * @param customerNick
     *            the value for crustomer_tb.customer_nick
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public void setCustomerNick(String customerNick) {
        this.customerNick = customerNick;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column crustomer_tb.customer_name
     *
     * @return the value of crustomer_tb.customer_name
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column crustomer_tb.customer_name
     *
     * @param customerName
     *            the value for crustomer_tb.customer_name
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column crustomer_tb.phone
     *
     * @return the value of crustomer_tb.phone
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column crustomer_tb.phone
     *
     * @param phone
     *            the value for crustomer_tb.phone
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column crustomer_tb.country
     *
     * @return the value of crustomer_tb.country
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public String getCountry() {
        return country;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column crustomer_tb.country
     *
     * @param country
     *            the value for crustomer_tb.country
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column crustomer_tb.state
     *
     * @return the value of crustomer_tb.state
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column crustomer_tb.state
     *
     * @param state
     *            the value for crustomer_tb.state
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column crustomer_tb.city
     *
     * @return the value of crustomer_tb.city
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column crustomer_tb.city
     *
     * @param city
     *            the value for crustomer_tb.city
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column crustomer_tb.district
     *
     * @return the value of crustomer_tb.district
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public String getDistrict() {
        return district;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column crustomer_tb.district
     *
     * @param district
     *            the value for crustomer_tb.district
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column crustomer_tb.address
     *
     * @return the value of crustomer_tb.address
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column crustomer_tb.address
     *
     * @param address
     *            the value for crustomer_tb.address
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column crustomer_tb.zip
     *
     * @return the value of crustomer_tb.zip
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public String getZip() {
        return zip;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column crustomer_tb.zip
     *
     * @param zip
     *            the value for crustomer_tb.zip
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column crustomer_tb.email
     *
     * @return the value of crustomer_tb.email
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column crustomer_tb.email
     *
     * @param email
     *            the value for crustomer_tb.email
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column crustomer_tb.qq
     *
     * @return the value of crustomer_tb.qq
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public String getQq() {
        return qq;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column crustomer_tb.qq
     *
     * @param qq
     *            the value for crustomer_tb.qq
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column crustomer_tb.gender
     *
     * @return the value of crustomer_tb.gender
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public Byte getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column crustomer_tb.gender
     *
     * @param gender
     *            the value for crustomer_tb.gender
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public void setGender(Byte gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column crustomer_tb.birthday
     *
     * @return the value of crustomer_tb.birthday
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column crustomer_tb.birthday
     *
     * @param birthday
     *            the value for crustomer_tb.birthday
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column crustomer_tb.age
     *
     * @return the value of crustomer_tb.age
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column crustomer_tb.age
     *
     * @param age
     *            the value for crustomer_tb.age
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column crustomer_tb.gmt_created
     *
     * @return the value of crustomer_tb.gmt_created
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column crustomer_tb.gmt_created
     *
     * @param gmtCreated
     *            the value for crustomer_tb.gmt_created
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column crustomer_tb.gmt_modified
     *
     * @return the value of crustomer_tb.gmt_modified
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column crustomer_tb.gmt_modified
     *
     * @param gmtModified
     *            the value for crustomer_tb.gmt_modified
     *
     * @mbg.generated Mon Feb 12 11:24:47 CST 2018
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}