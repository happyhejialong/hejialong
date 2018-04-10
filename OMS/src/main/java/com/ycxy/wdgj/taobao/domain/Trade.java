package com.ycxy.wdgj.taobao.domain;

import java.util.Date;

public  class Trade{
	public Order[] getOrders() {
		return orders;
	}
	public void setOrders(Order[] orders) {
		this.orders = orders;
	}
	private Order[] orders;
	private String sellerNick;
	private String picPath;
	private String payment;
	private Boolean sellerRate;
	private Double postFee;
	private String receiverName;
	private String receiverState;
	private String receiverAddress;
	private String receiverZip;
	private String receiverMobile;
	private String receiverPhone;
	private Date consign_time;
	private Double receivedPayment;
	private String receiver_country;
	private String receiver_town;
	private String order_tax_fee;
	private String shop_pick;
	private Integer tid;
	private Integer num;
	private Integer numIid;
	private String status;
	private String title;
	private String type;
	private Double price;
	private Double discountFee;
	private Double totalFee;
	private Date created;
	private Date payTime;
	private Date modified;
	private Date endTime;
	private Integer sellerFlag;
	private String buyerNick;
	private Boolean hasBuyerMessage;
	private Double creditCardFee;
	private String stepTradeStatus;
	private Double stepPaidFee;
	private String markDesc;
	private String shippingType;
	private Double adjustFee;
	private String tradeFrom;
	private Boolean buyerRate;
	private String receiverCity;
	private String receiver_district;
	private String o2o;
	private String o2oGuideId;
	private String o2oShopId;
	private String o2oGuideName;
	private String o2oShopName;
	private String o2oDelivery;
	private String rxAuditStatus;
	private Boolean postGateDeclare;
	private Boolean crossBondedDeclare;
	private String orderTaxPromotionFee;
	private String serviceType;
	public String getSellerNick() {
		return sellerNick;
	}
	public void setSellerNick(String sellerNick) {
		this.sellerNick = sellerNick;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public Boolean getSellerRate() {
		return sellerRate;
	}
	public void setSellerRate(Boolean sellerRate) {
		this.sellerRate = sellerRate;
	}
	public Double getPostFee() {
		return postFee;
	}
	public void setPostFee(Double postFee) {
		this.postFee = postFee;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverState() {
		return receiverState;
	}
	public void setReceiverState(String receiverState) {
		this.receiverState = receiverState;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public String getReceiverZip() {
		return receiverZip;
	}
	public void setReceiverZip(String receiverZip) {
		this.receiverZip = receiverZip;
	}
	public String getReceiverMobile() {
		return receiverMobile;
	}
	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public Date getConsign_time() {
		return consign_time;
	}
	public void setConsign_time(Date consign_time) {
		this.consign_time = consign_time;
	}
	public Double getReceivedPayment() {
		return receivedPayment;
	}
	public void setReceivedPayment(Double receivedPayment) {
		this.receivedPayment = receivedPayment;
	}
	public String getReceiver_country() {
		return receiver_country;
	}
	public void setReceiver_country(String receiver_country) {
		this.receiver_country = receiver_country;
	}
	public String getReceiver_town() {
		return receiver_town;
	}
	public void setReceiver_town(String receiver_town) {
		this.receiver_town = receiver_town;
	}
	public String getOrder_tax_fee() {
		return order_tax_fee;
	}
	public void setOrder_tax_fee(String order_tax_fee) {
		this.order_tax_fee = order_tax_fee;
	}
	public String getShop_pick() {
		return shop_pick;
	}
	public void setShop_pick(String shop_pick) {
		this.shop_pick = shop_pick;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getNumIid() {
		return numIid;
	}
	public void setNumIid(Integer numIid) {
		this.numIid = numIid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDiscountFee() {
		return discountFee;
	}
	public void setDiscountFee(Double discountFee) {
		this.discountFee = discountFee;
	}
	public Double getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getSellerFlag() {
		return sellerFlag;
	}
	public void setSellerFlag(Integer sellerFlag) {
		this.sellerFlag = sellerFlag;
	}
	public String getBuyerNick() {
		return buyerNick;
	}
	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
	}
	public Boolean getHasBuyerMessage() {
		return hasBuyerMessage;
	}
	public void setHasBuyerMessage(Boolean hasBuyerMessage) {
		this.hasBuyerMessage = hasBuyerMessage;
	}
	public Double getCreditCardFee() {
		return creditCardFee;
	}
	public void setCreditCardFee(Double creditCardFee) {
		this.creditCardFee = creditCardFee;
	}
	public String getStepTradeStatus() {
		return stepTradeStatus;
	}
	public void setStepTradeStatus(String stepTradeStatus) {
		this.stepTradeStatus = stepTradeStatus;
	}
	public Double getStepPaidFee() {
		return stepPaidFee;
	}
	public void setStepPaidFee(Double stepPaidFee) {
		this.stepPaidFee = stepPaidFee;
	}
	public String getMarkDesc() {
		return markDesc;
	}
	public void setMarkDesc(String markDesc) {
		this.markDesc = markDesc;
	}
	public String getShippingType() {
		return shippingType;
	}
	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
	}
	public Double getAdjustFee() {
		return adjustFee;
	}
	public void setAdjustFee(Double adjustFee) {
		this.adjustFee = adjustFee;
	}
	public String getTradeFrom() {
		return tradeFrom;
	}
	public void setTradeFrom(String tradeFrom) {
		this.tradeFrom = tradeFrom;
	}
	public Boolean getBuyerRate() {
		return buyerRate;
	}
	public void setBuyerRate(Boolean buyerRate) {
		this.buyerRate = buyerRate;
	}
	public String getReceiverCity() {
		return receiverCity;
	}
	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}
	public String getReceiver_district() {
		return receiver_district;
	}
	public void setReceiver_district(String receiver_district) {
		this.receiver_district = receiver_district;
	}
	public String getO2o() {
		return o2o;
	}
	public void setO2o(String o2o) {
		this.o2o = o2o;
	}
	public String getO2oGuideId() {
		return o2oGuideId;
	}
	public void setO2oGuideId(String o2oGuideId) {
		this.o2oGuideId = o2oGuideId;
	}
	public String getO2oShopId() {
		return o2oShopId;
	}
	public void setO2oShopId(String o2oShopId) {
		this.o2oShopId = o2oShopId;
	}
	public String getO2oGuideName() {
		return o2oGuideName;
	}
	public void setO2oGuideName(String o2oGuideName) {
		this.o2oGuideName = o2oGuideName;
	}
	public String getO2oShopName() {
		return o2oShopName;
	}
	public void setO2oShopName(String o2oShopName) {
		this.o2oShopName = o2oShopName;
	}
	public String getO2oDelivery() {
		return o2oDelivery;
	}
	public void setO2oDelivery(String o2oDelivery) {
		this.o2oDelivery = o2oDelivery;
	}
	public String getRxAuditStatus() {
		return rxAuditStatus;
	}
	public void setRxAuditStatus(String rxAuditStatus) {
		this.rxAuditStatus = rxAuditStatus;
	}
	public Boolean getPostGateDeclare() {
		return postGateDeclare;
	}
	public void setPostGateDeclare(Boolean postGateDeclare) {
		this.postGateDeclare = postGateDeclare;
	}
	public Boolean getCrossBondedDeclare() {
		return crossBondedDeclare;
	}
	public void setCrossBondedDeclare(Boolean crossBondedDeclare) {
		this.crossBondedDeclare = crossBondedDeclare;
	}
	public String getOrderTaxPromotionFee() {
		return orderTaxPromotionFee;
	}
	public void setOrderTaxPromotionFee(String orderTaxPromotionFee) {
		this.orderTaxPromotionFee = orderTaxPromotionFee;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	
}