/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.dto;

import com.ycxy.wdgj.model.TradeGoods;

/**
 * @since 2018年3月6日 下午2:07:47
 * @author hjl
 *
 */
public class SrcDestTradeGoodsDto {
    private TradeGoods[] srcTradeGoodsArr;
    private TradeGoods[] destTradeGoodsArr;

    public TradeGoods[] getSrcTradeGoodsArr() {
        return srcTradeGoodsArr;
    }

    public void setSrcTradeGoodsArr(TradeGoods[] srcTradeGoodsArr) {
        this.srcTradeGoodsArr = srcTradeGoodsArr;
    }

    public TradeGoods[] getDestTradeGoodsArr() {
        return destTradeGoodsArr;
    }

    public void setDestTradeGoodsArr(TradeGoods[] destTradeGoodsArr) {
        this.destTradeGoodsArr = destTradeGoodsArr;
    }

}
