package com.ycxy.wdgj.taobao.response;

import java.util.Date;

import com.ycxy.wdgj.taobao.domain.OnlineTrade;
import com.ycxy.wdgj.taobao.domain.Trade;

public class TradesSoldGetResponse {
	private Integer totalResults;
	private Boolean hasNext;
	private OnlineTrade[] trades;
	public Integer getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}
	public Boolean getHasNext() {
		return hasNext;
	}
	public void setHasNext(Boolean hasNext) {
		this.hasNext = hasNext;
	}
	public OnlineTrade[] getTrades() {
		return trades;
	}
	public void setTrades(OnlineTrade[] trades) {
		this.trades = trades;
	}
	

}
