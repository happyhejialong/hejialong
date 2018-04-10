package com.ycxy.wdgj.taobao.request;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.ycxy.wdgj.common.OmsConstant;
import com.ycxy.wdgj.common.utils.ObjectUtils;

public class TradesSoldGetRequest extends BaseRequest {
    private String fields = OmsConstant.FIELDS;
    private Date startCreated;
    private Date endCreated;
    private String status;
    private String buyerNick;
    private String type;
    private String extType;
    private String rateStatus;
    private String tag;
    private Integer pageNo;
    private Integer pageSize;
    private Boolean useHasNext;

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public Date getStartCreated() {
        return startCreated;
    }

    public void setStartCreated(Date startCreated) {
        this.startCreated = startCreated;
    }

    public Date getEndCreated() {
        return endCreated;
    }

    public void setEndCreated(Date endCreated) {
        this.endCreated = endCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExtType() {
        return extType;
    }

    public void setExtType(String extType) {
        this.extType = extType;
    }

    public String getRateStatus() {
        return rateStatus;
    }

    public void setRateStatus(String rateStatus) {
        this.rateStatus = rateStatus;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getUseHasNext() {
        return useHasNext;
    }

    public void setUseHasNext(Boolean useHasNext) {
        this.useHasNext = useHasNext;
    }

    /****
     * 将请求参数封装好
     * 
     * @return
     * @throws Exception
     */
    public Map<String, String> getTextParams() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        Class clazz = this.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object obj = field.get(this);
            if (ObjectUtils.isEmpty(obj) || StringUtils.isEmpty(obj)) {
                continue;
            }
            params.put(field.getName().toLowerCase(), String.valueOf(obj));
        }
        params.putAll(this.putBaseParams());
        return params;
    }

}
