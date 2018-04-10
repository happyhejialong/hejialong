package com.ycxy.wdgj.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Districts {

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * districts.id
     * 
     * @mbg.generated Thu Feb 22 11:42:38 CST 2018
     */
    private Integer id;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * districts.citycode
     * 
     * @mbg.generated Thu Feb 22 11:42:38 CST 2018
     */
    @JsonIgnoreProperties("citycode")
    private Object citycode;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * districts.adcode
     * 
     * @mbg.generated Thu Feb 22 11:42:38 CST 2018
     */
    @JsonIgnoreProperties("adcode")
    private Integer adcode;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * districts.name
     * 
     * @mbg.generated Thu Feb 22 11:42:38 CST 2018
     */
    @JsonIgnoreProperties("name")
    private String name;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * districts.center
     * 
     * @mbg.generated Thu Feb 22 11:42:38 CST 2018
     */
    @JsonIgnoreProperties("center")
    private String center;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * districts.level
     * 
     * @mbg.generated Thu Feb 22 11:42:38 CST 2018
     */
    @JsonIgnoreProperties("level")
    private String level;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * districts.keyword
     * 
     * @mbg.generated Thu Feb 22 11:42:38 CST 2018
     */
    private String keyword;

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column districts.id
     * 
     * @return the value of districts.id
     * @mbg.generated Thu Feb 22 11:42:38 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column districts.id
     * 
     * @param id
     *            the value for districts.id
     * @mbg.generated Thu Feb 22 11:42:38 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column districts.citycode
     * 
     * @return the value of districts.citycode
     * @mbg.generated Thu Feb 22 11:42:38 CST 2018
     */
    public String getCitycode() {

        if (citycode instanceof List) {
            List temp = (List) citycode;
            if (temp.size() == 0) {
                return "[]";
            } else {
                String result = "[";
                for (int i = 0, j = temp.size(); i < j; i++) {
                    result += temp.get(i).toString();
                }
                result += "]";
                return result;
            }
        }
        return citycode.toString();
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column districts.citycode
     * 
     * @param citycode
     *            the value for districts.citycode
     * @mbg.generated Thu Feb 22 11:42:38 CST 2018
     */
    public void setCitycode(Object citycode) {
        this.citycode = citycode;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column districts.adcode
     * 
     * @return the value of districts.adcode
     * @mbg.generated Thu Feb 22 11:42:38 CST 2018
     */
    public Integer getAdcode() {
        return adcode;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column districts.adcode
     * 
     * @param adcode
     *            the value for districts.adcode
     * @mbg.generated Thu Feb 22 11:42:38 CST 2018
     */
    public void setAdcode(Integer adcode) {
        this.adcode = adcode;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column districts.name
     * 
     * @return the value of districts.name
     * @mbg.generated Thu Feb 22 11:42:38 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column districts.name
     * 
     * @param name
     *            the value for districts.name
     * @mbg.generated Thu Feb 22 11:42:38 CST 2018
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column districts.center
     * 
     * @return the value of districts.center
     * @mbg.generated Thu Feb 22 11:42:38 CST 2018
     */
    public String getCenter() {
        return center;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column districts.center
     * 
     * @param center
     *            the value for districts.center
     * @mbg.generated Thu Feb 22 11:42:38 CST 2018
     */
    public void setCenter(String center) {
        this.center = center;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column districts.level
     * 
     * @return the value of districts.level
     * @mbg.generated Thu Feb 22 11:42:38 CST 2018
     */
    public String getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column districts.level
     * 
     * @param level
     *            the value for districts.level
     * @mbg.generated Thu Feb 22 11:42:38 CST 2018
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column districts.keyword
     * 
     * @return the value of districts.keyword
     * @mbg.generated Thu Feb 22 11:42:38 CST 2018
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column districts.keyword
     * 
     * @param keyword
     *            the value for districts.keyword
     * @mbg.generated Thu Feb 22 11:42:38 CST 2018
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

}