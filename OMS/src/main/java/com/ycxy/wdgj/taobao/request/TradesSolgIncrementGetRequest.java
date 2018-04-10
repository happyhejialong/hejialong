package com.ycxy.wdgj.taobao.request;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.ycxy.wdgj.common.utils.ObjectUtils;

public class TradesSolgIncrementGetRequest extends BaseRequest{
	private String field;
	private Date startModified;
	private Date endModified;
	private String status;
	private String type; 
	private String buyerNick;
	private String extType;
	private String tag;
	private Integer pageNo;
	private Integer pageSize ;
	private Boolean useHasNext;
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public Date getStartModified() {
		return startModified;
	}
	public void setStartModified(Date startModified) {
		this.startModified = startModified;
	}
	public Date getEndModified() {
		return endModified;
	}
	public void setEndModified(Date endModified) {
		this.endModified = endModified;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBuyerNick() {
		return buyerNick;
	}
	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
	}
	public String getExtType() {
		return extType;
	}
	public void setExtType(String extType) {
		this.extType = extType;
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
	 * @return
	 * @throws Exception
	 */
	public Map<String,String> getTextParams() throws Exception{
		Map<String,String> params=new HashMap<String,String>();
		Class clazz=this.getClass();
		for(Field field:clazz.getDeclaredFields()){
			field.setAccessible(true);
			Object obj=field.get(this);
			if(ObjectUtils.isEmpty(obj) || StringUtils.isEmpty(obj)){
				continue;
			}
			params.put(field.getName().toLowerCase(), String.valueOf(obj));
		}
		return params;
	}
}
