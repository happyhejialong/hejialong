package com.ycxy.wdgj.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TradeGoods {

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.id
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private Integer id;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.buy_num
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private Integer buyNum;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.trade_id
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private Long tradeId;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.sub_trade_id
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private Long subTradeId;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.goods_id
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private String goodsId;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.goods_no
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private String goodsNo;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.goods_name
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private String goodsName;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.spec_id
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private Long specId;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.spec_name
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private String specName;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.barcode
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private String barcode;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.sell_count
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private Integer sellCount;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.unit
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private String unit;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.sell_price
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private Double sellPrice;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.sell_total
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private Double sellTotal;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.tax_fee
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private Double taxFee;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.goods_memo
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private String goodsMemo;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.is_fit
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private Byte isFit;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.is_gift
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private Byte isGift;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.sub_trade_status
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private Byte subTradeStatus;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.refund_status
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private Byte refundStatus;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.trade_goods_no
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private String tradeGoodsNo;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.trade_goods_name
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private String tradeGoodsName;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.trade_goods_spec
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private String tradeGoodsSpec;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.trade_goods_unit
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private String tradeGoodsUnit;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.source_trade_no
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private Long sourceTradeNo;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.source_subtrade_no
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private Long sourceSubtradeNo;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.souce_trade_status
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private Byte souceTradeStatus;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.is_delete
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private Byte isDelete;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.gmt_create
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private Date gmtCreate;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * trade_goods.gmt_modified
     * 
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    private Date gmtModified;

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.id
     * 
     * @return the value of trade_goods.id
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.id
     * 
     * @param id
     *            the value for trade_goods.id
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.buy_num
     * 
     * @return the value of trade_goods.buy_num
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public Integer getBuyNum() {
        return buyNum;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.buy_num
     * 
     * @param buyNum
     *            the value for trade_goods.buy_num
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.trade_id
     * 
     * @return the value of trade_goods.trade_id
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public Long getTradeId() {
        return tradeId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.trade_id
     * 
     * @param tradeId
     *            the value for trade_goods.trade_id
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.sub_trade_id
     * 
     * @return the value of trade_goods.sub_trade_id
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public Long getSubTradeId() {
        return subTradeId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.sub_trade_id
     * 
     * @param subTradeId
     *            the value for trade_goods.sub_trade_id
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setSubTradeId(Long subTradeId) {
        this.subTradeId = subTradeId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.goods_id
     * 
     * @return the value of trade_goods.goods_id
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.goods_id
     * 
     * @param goodsId
     *            the value for trade_goods.goods_id
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.goods_no
     * 
     * @return the value of trade_goods.goods_no
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public String getGoodsNo() {
        return goodsNo;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.goods_no
     * 
     * @param goodsNo
     *            the value for trade_goods.goods_no
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.goods_name
     * 
     * @return the value of trade_goods.goods_name
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.goods_name
     * 
     * @param goodsName
     *            the value for trade_goods.goods_name
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.spec_id
     * 
     * @return the value of trade_goods.spec_id
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public Long getSpecId() {
        return specId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.spec_id
     * 
     * @param specId
     *            the value for trade_goods.spec_id
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.spec_name
     * 
     * @return the value of trade_goods.spec_name
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public String getSpecName() {
        return specName;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.spec_name
     * 
     * @param specName
     *            the value for trade_goods.spec_name
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setSpecName(String specName) {
        this.specName = specName;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.barcode
     * 
     * @return the value of trade_goods.barcode
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.barcode
     * 
     * @param barcode
     *            the value for trade_goods.barcode
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.sell_count
     * 
     * @return the value of trade_goods.sell_count
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public Integer getSellCount() {
        return sellCount;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.sell_count
     * 
     * @param sellCount
     *            the value for trade_goods.sell_count
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setSellCount(Integer sellCount) {
        this.sellCount = sellCount;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.unit
     * 
     * @return the value of trade_goods.unit
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public String getUnit() {
        return unit;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.unit
     * 
     * @param unit
     *            the value for trade_goods.unit
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.sell_price
     * 
     * @return the value of trade_goods.sell_price
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public Double getSellPrice() {
        return sellPrice;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.sell_price
     * 
     * @param sellPrice
     *            the value for trade_goods.sell_price
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.sell_total
     * 
     * @return the value of trade_goods.sell_total
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public Double getSellTotal() {
        return sellTotal;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.sell_total
     * 
     * @param sellTotal
     *            the value for trade_goods.sell_total
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setSellTotal(Double sellTotal) {
        this.sellTotal = sellTotal;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.tax_fee
     * 
     * @return the value of trade_goods.tax_fee
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public Double getTaxFee() {
        return taxFee;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.tax_fee
     * 
     * @param taxFee
     *            the value for trade_goods.tax_fee
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setTaxFee(Double taxFee) {
        this.taxFee = taxFee;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.goods_memo
     * 
     * @return the value of trade_goods.goods_memo
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public String getGoodsMemo() {
        return goodsMemo;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.goods_memo
     * 
     * @param goodsMemo
     *            the value for trade_goods.goods_memo
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setGoodsMemo(String goodsMemo) {
        this.goodsMemo = goodsMemo;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.is_fit
     * 
     * @return the value of trade_goods.is_fit
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public Byte getIsFit() {
        return isFit;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.is_fit
     * 
     * @param isFit
     *            the value for trade_goods.is_fit
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setIsFit(Byte isFit) {
        this.isFit = isFit;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.is_gift
     * 
     * @return the value of trade_goods.is_gift
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public Byte getIsGift() {
        return isGift;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.is_gift
     * 
     * @param isGift
     *            the value for trade_goods.is_gift
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setIsGift(Byte isGift) {
        this.isGift = isGift;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.sub_trade_status
     * 
     * @return the value of trade_goods.sub_trade_status
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public Byte getSubTradeStatus() {
        return subTradeStatus;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.sub_trade_status
     * 
     * @param subTradeStatus
     *            the value for trade_goods.sub_trade_status
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setSubTradeStatus(Byte subTradeStatus) {
        this.subTradeStatus = subTradeStatus;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.refund_status
     * 
     * @return the value of trade_goods.refund_status
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public Byte getRefundStatus() {
        return refundStatus;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.refund_status
     * 
     * @param refundStatus
     *            the value for trade_goods.refund_status
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setRefundStatus(Byte refundStatus) {
        this.refundStatus = refundStatus;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.trade_goods_no
     * 
     * @return the value of trade_goods.trade_goods_no
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public String getTradeGoodsNo() {
        return tradeGoodsNo;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.trade_goods_no
     * 
     * @param tradeGoodsNo
     *            the value for trade_goods.trade_goods_no
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setTradeGoodsNo(String tradeGoodsNo) {
        this.tradeGoodsNo = tradeGoodsNo;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.trade_goods_name
     * 
     * @return the value of trade_goods.trade_goods_name
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public String getTradeGoodsName() {
        return tradeGoodsName;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.trade_goods_name
     * 
     * @param tradeGoodsName
     *            the value for trade_goods.trade_goods_name
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setTradeGoodsName(String tradeGoodsName) {
        this.tradeGoodsName = tradeGoodsName;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.trade_goods_spec
     * 
     * @return the value of trade_goods.trade_goods_spec
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public String getTradeGoodsSpec() {
        return tradeGoodsSpec;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.trade_goods_spec
     * 
     * @param tradeGoodsSpec
     *            the value for trade_goods.trade_goods_spec
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setTradeGoodsSpec(String tradeGoodsSpec) {
        this.tradeGoodsSpec = tradeGoodsSpec;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.trade_goods_unit
     * 
     * @return the value of trade_goods.trade_goods_unit
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public String getTradeGoodsUnit() {
        return tradeGoodsUnit;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.trade_goods_unit
     * 
     * @param tradeGoodsUnit
     *            the value for trade_goods.trade_goods_unit
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setTradeGoodsUnit(String tradeGoodsUnit) {
        this.tradeGoodsUnit = tradeGoodsUnit;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.source_trade_no
     * 
     * @return the value of trade_goods.source_trade_no
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public Long getSourceTradeNo() {
        return sourceTradeNo;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.source_trade_no
     * 
     * @param sourceTradeNo
     *            the value for trade_goods.source_trade_no
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setSourceTradeNo(Long sourceTradeNo) {
        this.sourceTradeNo = sourceTradeNo;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.source_subtrade_no
     * 
     * @return the value of trade_goods.source_subtrade_no
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public Long getSourceSubtradeNo() {
        return sourceSubtradeNo;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.source_subtrade_no
     * 
     * @param sourceSubtradeNo
     *            the value for trade_goods.source_subtrade_no
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setSourceSubtradeNo(Long sourceSubtradeNo) {
        this.sourceSubtradeNo = sourceSubtradeNo;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.souce_trade_status
     * 
     * @return the value of trade_goods.souce_trade_status
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public Byte getSouceTradeStatus() {
        return souceTradeStatus;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.souce_trade_status
     * 
     * @param souceTradeStatus
     *            the value for trade_goods.souce_trade_status
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setSouceTradeStatus(Byte souceTradeStatus) {
        this.souceTradeStatus = souceTradeStatus;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.is_delete
     * 
     * @return the value of trade_goods.is_delete
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.is_delete
     * 
     * @param isDelete
     *            the value for trade_goods.is_delete
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.gmt_create
     * 
     * @return the value of trade_goods.gmt_create
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.gmt_create
     * 
     * @param gmtCreate
     *            the value for trade_goods.gmt_create
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database
     * column trade_goods.gmt_modified
     * 
     * @return the value of trade_goods.gmt_modified
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database
     * column trade_goods.gmt_modified
     * 
     * @param gmtModified
     *            the value for trade_goods.gmt_modified
     * @mbg.generated Fri Feb 23 09:36:54 CST 2018
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        TradeGoods other = (TradeGoods) obj;
        if (goodsId == null) {
            if (other.goodsId != null) {
                return false;
            }
        } else if (!goodsId.equals(other.goodsId)) {
            return false;
        }
        return true;
    }

}