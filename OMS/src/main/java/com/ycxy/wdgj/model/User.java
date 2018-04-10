package com.ycxy.wdgj.model;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.ycxy.wdgj.valid.delete;
import com.ycxy.wdgj.valid.insert;
import com.ycxy.wdgj.valid.select;
import com.ycxy.wdgj.valid.update;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_tb.id
     *
     * @mbg.generated Mon Feb 12 17:00:02 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_tb.username
     *
     * @mbg.generated Mon Feb 12 17:00:02 CST 2018
     */
    @NotNull(groups={insert.class,delete.class,update.class,select.class})
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_tb.password
     *
     * @mbg.generated Mon Feb 12 17:00:02 CST 2018
     */
    @NotNull(groups={insert.class,update.class})
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_tb.phone
     *
     * @mbg.generated Mon Feb 12 17:00:02 CST 2018
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_tb.email
     *
     * @mbg.generated Mon Feb 12 17:00:02 CST 2018
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_tb.auth_group
     *
     * @mbg.generated Mon Feb 12 17:00:02 CST 2018
     */
    private Byte authGroup;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_tb.sort_id
     *
     * @mbg.generated Mon Feb 12 17:00:02 CST 2018
     */
    private Byte sortId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_tb.id
     *
     * @return the value of user_tb.id
     *
     * @mbg.generated Mon Feb 12 17:00:02 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_tb.id
     *
     * @param id the value for user_tb.id
     *
     * @mbg.generated Mon Feb 12 17:00:02 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_tb.username
     *
     * @return the value of user_tb.username
     *
     * @mbg.generated Mon Feb 12 17:00:02 CST 2018
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_tb.username
     *
     * @param username the value for user_tb.username
     *
     * @mbg.generated Mon Feb 12 17:00:02 CST 2018
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_tb.password
     *
     * @return the value of user_tb.password
     *
     * @mbg.generated Mon Feb 12 17:00:02 CST 2018
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_tb.password
     *
     * @param password the value for user_tb.password
     *
     * @mbg.generated Mon Feb 12 17:00:02 CST 2018
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_tb.phone
     *
     * @return the value of user_tb.phone
     *
     * @mbg.generated Mon Feb 12 17:00:02 CST 2018
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_tb.phone
     *
     * @param phone the value for user_tb.phone
     *
     * @mbg.generated Mon Feb 12 17:00:02 CST 2018
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_tb.email
     *
     * @return the value of user_tb.email
     *
     * @mbg.generated Mon Feb 12 17:00:02 CST 2018
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_tb.email
     *
     * @param email the value for user_tb.email
     *
     * @mbg.generated Mon Feb 12 17:00:02 CST 2018
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_tb.auth_group
     *
     * @return the value of user_tb.auth_group
     *
     * @mbg.generated Mon Feb 12 17:00:02 CST 2018
     */
    public Byte getAuthGroup() {
        return authGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_tb.auth_group
     *
     * @param authGroup the value for user_tb.auth_group
     *
     * @mbg.generated Mon Feb 12 17:00:02 CST 2018
     */
    public void setAuthGroup(Byte authGroup) {
        this.authGroup = authGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_tb.sort_id
     *
     * @return the value of user_tb.sort_id
     *
     * @mbg.generated Mon Feb 12 17:00:02 CST 2018
     */
    public Byte getSortId() {
        return sortId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_tb.sort_id
     *
     * @param sortId the value for user_tb.sort_id
     *
     * @mbg.generated Mon Feb 12 17:00:02 CST 2018
     */
    public void setSortId(Byte sortId) {
        this.sortId = sortId;
    }
}