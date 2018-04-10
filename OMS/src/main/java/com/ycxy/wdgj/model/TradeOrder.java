package com.ycxy.wdgj.model;

import java.io.Serializable;
import java.util.Date;

import com.ycxy.wdgj.dto.BaseParamDto;

public class TradeOrder  implements Serializable{

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.id
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.pay_time
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private Date payTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.logisticsCode
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private String logisticscode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.logisticsName
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private String logisticsname;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.logisticsId
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private String logisticsid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.trade_id
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private Long tradeId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.trade_no
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private Long tradeNo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.source_trade_id
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private String sourceTradeId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.source_trade_no
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private String sourceTradeNo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.shop_id
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private Long shopId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.shop_name
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private String shopName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.seller
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private String seller;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.trade_type
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private Byte tradeType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.total_money
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private Double totalMoney;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.seller_memo
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private String sellerMemo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.buyer_memo
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private String buyerMemo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.append_memo
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private String appendMemo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.payment
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private Double payment;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.tax_fee
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private Double taxFee;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.post_fee
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private Double postFee;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.register
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private String register;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.auditor
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private String auditor;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.reviewer
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private String reviewer;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.is_delete
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private Byte isDelete;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.gmt_create
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private Date gmtCreate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.gmt_modified
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private Date gmtModified;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.trade_status
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private Byte tradeStatus;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_order.user_id
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	private Integer userId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.id
	 * @return  the value of trade_order.id
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.id
	 * @param id  the value for trade_order.id
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.pay_time
	 * @return  the value of trade_order.pay_time
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public Date getPayTime() {
		return payTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.pay_time
	 * @param payTime  the value for trade_order.pay_time
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.logisticsCode
	 * @return  the value of trade_order.logisticsCode
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public String getLogisticscode() {
		return logisticscode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.logisticsCode
	 * @param logisticscode  the value for trade_order.logisticsCode
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setLogisticscode(String logisticscode) {
		this.logisticscode = logisticscode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.logisticsName
	 * @return  the value of trade_order.logisticsName
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public String getLogisticsname() {
		return logisticsname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.logisticsName
	 * @param logisticsname  the value for trade_order.logisticsName
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setLogisticsname(String logisticsname) {
		this.logisticsname = logisticsname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.logisticsId
	 * @return  the value of trade_order.logisticsId
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public String getLogisticsid() {
		return logisticsid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.logisticsId
	 * @param logisticsid  the value for trade_order.logisticsId
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.trade_id
	 * @return  the value of trade_order.trade_id
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public Long getTradeId() {
		return tradeId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.trade_id
	 * @param tradeId  the value for trade_order.trade_id
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setTradeId(Long tradeId) {
		this.tradeId = tradeId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.trade_no
	 * @return  the value of trade_order.trade_no
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public Long getTradeNo() {
		return tradeNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.trade_no
	 * @param tradeNo  the value for trade_order.trade_no
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setTradeNo(Long tradeNo) {
		this.tradeNo = tradeNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.source_trade_id
	 * @return  the value of trade_order.source_trade_id
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public String getSourceTradeId() {
		return sourceTradeId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.source_trade_id
	 * @param sourceTradeId  the value for trade_order.source_trade_id
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setSourceTradeId(String sourceTradeId) {
		this.sourceTradeId = sourceTradeId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.source_trade_no
	 * @return  the value of trade_order.source_trade_no
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public String getSourceTradeNo() {
		return sourceTradeNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.source_trade_no
	 * @param sourceTradeNo  the value for trade_order.source_trade_no
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setSourceTradeNo(String sourceTradeNo) {
		this.sourceTradeNo = sourceTradeNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.shop_id
	 * @return  the value of trade_order.shop_id
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public Long getShopId() {
		return shopId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.shop_id
	 * @param shopId  the value for trade_order.shop_id
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.shop_name
	 * @return  the value of trade_order.shop_name
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.shop_name
	 * @param shopName  the value for trade_order.shop_name
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.seller
	 * @return  the value of trade_order.seller
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public String getSeller() {
		return seller;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.seller
	 * @param seller  the value for trade_order.seller
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setSeller(String seller) {
		this.seller = seller;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.trade_type
	 * @return  the value of trade_order.trade_type
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public Byte getTradeType() {
		return tradeType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.trade_type
	 * @param tradeType  the value for trade_order.trade_type
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setTradeType(Byte tradeType) {
		this.tradeType = tradeType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.total_money
	 * @return  the value of trade_order.total_money
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public Double getTotalMoney() {
		return totalMoney;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.total_money
	 * @param totalMoney  the value for trade_order.total_money
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.seller_memo
	 * @return  the value of trade_order.seller_memo
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public String getSellerMemo() {
		return sellerMemo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.seller_memo
	 * @param sellerMemo  the value for trade_order.seller_memo
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setSellerMemo(String sellerMemo) {
		this.sellerMemo = sellerMemo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.buyer_memo
	 * @return  the value of trade_order.buyer_memo
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public String getBuyerMemo() {
		return buyerMemo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.buyer_memo
	 * @param buyerMemo  the value for trade_order.buyer_memo
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setBuyerMemo(String buyerMemo) {
		this.buyerMemo = buyerMemo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.append_memo
	 * @return  the value of trade_order.append_memo
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public String getAppendMemo() {
		return appendMemo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.append_memo
	 * @param appendMemo  the value for trade_order.append_memo
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setAppendMemo(String appendMemo) {
		this.appendMemo = appendMemo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.payment
	 * @return  the value of trade_order.payment
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public Double getPayment() {
		return payment;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.payment
	 * @param payment  the value for trade_order.payment
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setPayment(Double payment) {
		this.payment = payment;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.tax_fee
	 * @return  the value of trade_order.tax_fee
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public Double getTaxFee() {
		return taxFee;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.tax_fee
	 * @param taxFee  the value for trade_order.tax_fee
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setTaxFee(Double taxFee) {
		this.taxFee = taxFee;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.post_fee
	 * @return  the value of trade_order.post_fee
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public Double getPostFee() {
		return postFee;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.post_fee
	 * @param postFee  the value for trade_order.post_fee
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setPostFee(Double postFee) {
		this.postFee = postFee;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.register
	 * @return  the value of trade_order.register
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public String getRegister() {
		return register;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.register
	 * @param register  the value for trade_order.register
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setRegister(String register) {
		this.register = register;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.auditor
	 * @return  the value of trade_order.auditor
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public String getAuditor() {
		return auditor;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.auditor
	 * @param auditor  the value for trade_order.auditor
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.reviewer
	 * @return  the value of trade_order.reviewer
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public String getReviewer() {
		return reviewer;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.reviewer
	 * @param reviewer  the value for trade_order.reviewer
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.is_delete
	 * @return  the value of trade_order.is_delete
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public Byte getIsDelete() {
		return isDelete;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.is_delete
	 * @param isDelete  the value for trade_order.is_delete
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setIsDelete(Byte isDelete) {
		this.isDelete = isDelete;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.gmt_create
	 * @return  the value of trade_order.gmt_create
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.gmt_create
	 * @param gmtCreate  the value for trade_order.gmt_create
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.gmt_modified
	 * @return  the value of trade_order.gmt_modified
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public Date getGmtModified() {
		return gmtModified;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.gmt_modified
	 * @param gmtModified  the value for trade_order.gmt_modified
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.trade_status
	 * @return  the value of trade_order.trade_status
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public Byte getTradeStatus() {
		return tradeStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.trade_status
	 * @param tradeStatus  the value for trade_order.trade_status
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setTradeStatus(Byte tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_order.user_id
	 * @return  the value of trade_order.user_id
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_order.user_id
	 * @param userId  the value for trade_order.user_id
	 * @mbg.generated  Tue Apr 03 21:04:41 CST 2018
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}