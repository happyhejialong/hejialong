package com.ycxy.wdgj.dto;

import com.ycxy.wdgj.model.TradeOrder;

public class ConditionDto  extends BaseParamDto{
	private TradeOrder tradeOrder;
	private PageInfo pageInfo;

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public TradeOrder getTradeOrder() {
		return tradeOrder;
	}

	public void setTradeOrder(TradeOrder tradeOrder) {
		this.tradeOrder = tradeOrder;
	}
	
	
	
}
