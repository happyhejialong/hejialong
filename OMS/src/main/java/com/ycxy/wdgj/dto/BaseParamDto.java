package com.ycxy.wdgj.dto;

import java.util.Date;

public class BaseParamDto {
	private Date oneTimeBegin;
	private Date oneTimeEnd;
	private Date twoTimeBegin;
	private Date twoTimeEnd;
	private LikeField likeField;
	public static class LikeField{
		public String likeFieldName;
		public String likeFieldValue;
		public String getLikeFieldName() {
			return likeFieldName;
		}
		public void setLikeFieldName(String likeFieldName) {
			this.likeFieldName = likeFieldName;
		}
		public String getLikeFieldValue() {
			return likeFieldValue;
		}
		public void setLikeFieldValue(String likeFieldValue) {
			this.likeFieldValue = likeFieldValue;
		}
		
	}
	public LikeField getLikeField() {
		return likeField;
	}
	public void setLikeField(LikeField likeField) {
		this.likeField = likeField;
	}
	public Date getOneTimeBegin() {
		return oneTimeBegin;
	}
	public void setOneTimeBegin(Date oneTimeBegin) {
		this.oneTimeBegin = oneTimeBegin;
	}
	public Date getOneTimeEnd() {
		return oneTimeEnd;
	}
	public void setOneTimeEnd(Date oneTimeEnd) {
		this.oneTimeEnd = oneTimeEnd;
	}
	public Date getTwoTimeBegin() {
		return twoTimeBegin;
	}
	public void setTwoTimeBegin(Date twoTimeBegin) {
		this.twoTimeBegin = twoTimeBegin;
	}
	public Date getTwoTimeEnd() {
		return twoTimeEnd;
	}
	public void setTwoTimeEnd(Date twoTimeEnd) {
		this.twoTimeEnd = twoTimeEnd;
	}
	
	
}
