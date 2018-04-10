package com.ycxy.wdgj.common.utils;

import java.util.ArrayList;
import java.util.List;

import com.ycxy.wdgj.dto.TradeOrderDto;
import com.ycxy.wdgj.model.TradeCustomer;
import com.ycxy.wdgj.model.TradeGoods;
import com.ycxy.wdgj.model.TradeOrder;
import com.ycxy.wdgj.model.TradeReceiver;
import com.ycxy.wdgj.taobao.domain.OnlineOrder;
import com.ycxy.wdgj.taobao.domain.OnlineTrade;
import com.ycxy.wdgj.taobao.response.TradesSoldGetResponse;

public class ConvertUtils {
	/****
	 * 将淘宝订单转换为本地平台的订单
	 * TradesSoldGet==>TradeOrderDto
	 */
	public static List<TradeOrderDto> convert(TradesSoldGetResponse response){
		List<TradeOrderDto> tradeOrderDtoList=new ArrayList<TradeOrderDto>();		
		for(OnlineTrade onlineTrade:response.getTrades()){
			TradeOrderDto tradeOrderDto=new TradeOrderDto();
			TradeOrder tradeOrder=new TradeOrder();		
			//tradeOrder.setAuditor(auditor);
			//tradeOrder.setBuyerMemo(buyerMemo);
			//tradeOrder.setLogisticsid(onlineTrade.get);
			//tradeOrder.setLogisticsname(onlineTrade.getC);
			tradeOrder.setPayment(Double.parseDouble(onlineTrade.getPayment()));
			tradeOrder.setPostFee(onlineTrade.getPostFee());
			tradeOrder.setSeller(onlineTrade.getSellerNick());
			//tradeOrder.setSellerMemo(sellerMemo);
			//tradeOrder.setShopId();
			//tradeOrder.setShopName(onlineTrade.getO2oShopName());
			tradeOrder.setSourceTradeId(onlineTrade.getTid());
			tradeOrder.setSourceTradeNo(onlineTrade.getTid());
			tradeOrder.setTaxFee(Double.parseDouble(onlineTrade.getOrderTaxFee()));
			tradeOrder.setTotalMoney(onlineTrade.getTotalFee());
			//TODO  枚举映射
			//tradeOrder.setTradeStatus();
			//TODO  枚举映射
			//tradeOrder.setTradeType(onlineTrade.getType());
			//TODO
			//tradeOrder.setUserId();
			
			tradeOrderDto.setTradeOrder(tradeOrder);
			//TODO 转换  tradeCustomer
			TradeCustomer tradeCustomer=new TradeCustomer();
			tradeCustomer.setCustomerName(onlineTrade.getReceiverName());
			tradeCustomer.setCustomerNick(onlineTrade.getBuyerNick());
			//TODO  枚举映射
			//tradeCustomer.setCustomerType(onlineTrade.getC);
			//tradeCustomer.setEmail();
			tradeCustomer.setPhone(onlineTrade.getReceiverPhone());
			tradeCustomer.setZip(onlineTrade.getReceiverZip());
			tradeOrderDto.setTradeCustomer(tradeCustomer);
			//TODO 转换 tradeReceiver
			TradeReceiver tradeReceiver=new TradeReceiver();
			tradeReceiver.setAddress(onlineTrade.getReceiverAddress());
			tradeReceiver.setCity(onlineTrade.getReceiverCity());
			tradeReceiver.setCountry(onlineTrade.getReceiverCountry());
			tradeReceiver.setDistrict(onlineTrade.getReceiverDistrict());
			//tradeReceiver.setIdentityCardNo(onlineTrade.Car);
			//tradeReceiver.setIdentityCardType(identityCardType);
			tradeReceiver.setReceiverName(onlineTrade.getReceiverName());
			tradeReceiver.setReceiverPhone(onlineTrade.getReceiverPhone());
			tradeReceiver.setState(onlineTrade.getReceiverState());
			tradeOrderDto.setTradeReceiver(tradeReceiver);
			List<TradeGoods> tradeGoodsArr=new ArrayList<TradeGoods>();
			for(OnlineOrder onlineOrder:onlineTrade.getOrders()){
				TradeGoods tradeGoods=new TradeGoods();
				//tradeGoods.setBarcode(onlineOrder.getB);
				tradeGoods.setBuyNum(onlineOrder.getNum());
				tradeGoods.setGoodsId(onlineOrder.getIid());
				//tradeGoods.setGoodsMemo(onlineOrder.getmem);
				tradeGoods.setGoodsName(onlineOrder.getTitle());
				tradeGoods.setGoodsNo(onlineOrder.getIid());
				//TODO  枚举映射
				//tradeGoods.setRefundStatus(onlineOrder.getRefundStatus());
				tradeGoods.setSellCount(onlineOrder.getNum());
				tradeGoods.setSellPrice(Double.parseDouble(onlineOrder.getPrice()));
				tradeGoods.setSellTotal(onlineOrder.getTotalFee());
				//TODO  枚举映射
				//tradeGoods.setSouceTradeStatus(onlineOrder.getStatus());
				tradeGoods.setTaxFee(Double.parseDouble(onlineOrder.getSubOrderTaxFee()));
				tradeGoods.setTradeGoodsName(onlineOrder.getItemMealName());
				tradeGoods.setTradeGoodsNo(onlineOrder.getIid());
				tradeGoods.setTradeGoodsSpec(onlineOrder.getSkuPropertiesName());
				tradeGoodsArr.add(tradeGoods);
			}
			tradeOrderDto.setTradeGoodsArr(tradeGoodsArr);
			tradeOrderDtoList.add(tradeOrderDto);
		}
		return tradeOrderDtoList;
	}
}
