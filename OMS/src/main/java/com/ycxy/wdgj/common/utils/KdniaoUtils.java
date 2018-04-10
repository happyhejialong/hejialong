package com.ycxy.wdgj.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ycxy.wdgj.common.HttpClientUtils;
import com.ycxy.wdgj.common.OmsConstant;
import com.ycxy.wdgj.dto.RequestData;
import com.ycxy.wdgj.dto.TradeOrderDto;
import com.ycxy.wdgj.model.TradeGoods;
import com.ycxy.wdgj.model.TradeOrder;
import com.ycxy.wdgj.model.TradeReceiver;

public class KdniaoUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Json方式 智选物流
     * 
     * @throws Exception
     */
    public static String getExpRecommendByJson(TradeOrderDto tradeOrderDto) throws Exception {
        TradeOrder tradeOrder = tradeOrderDto.getTradeOrder();
        TradeReceiver tradeReceiver = tradeOrderDto.getTradeReceiver();
        List<TradeGoods> tradeGoods = tradeOrderDto.getTradeGoodsArr();
        String tradeGoodsStr = "";
        for (TradeGoods tradeGood : tradeGoods) {
            tradeGoodsStr += "{'ProductName':'" + tradeGood.getGoodsName() + "','Volume':'','Weight':'1'},";
        }
        tradeGoodsStr = tradeGoodsStr.substring(0, tradeGoodsStr.length() - 1);
        String requestData = "{'MemberID':'123456','WarehouseID':'1','Detail':[{'OrderCode':'" + tradeOrder.getTradeId()
                + "','IsCOD':0,'Sender':{'ProvinceName':'广东省','CityName':'广州','ExpAreaName':'龙岗区','Subdistrict':'布吉街道','Address':'518000'},'Receiver':{'ProvinceName':'"
                + tradeReceiver.getState() + "','CityName':'" + tradeReceiver.getCity() + "','ExpAreaName':'" + tradeReceiver.getDistrict()
                + "','Subdistrict':'" + tradeReceiver.getDistrict() + "','Address':'" + tradeReceiver.getAddress() + "'},'Goods':[" + tradeGoodsStr + "]}]}";
        System.out.println(requestData);
        Map<String, String> params = new HashMap<String, String>();
        params.put("RequestData", urlEncoder(requestData, "UTF-8"));
        params.put("EBusinessID", OmsConstant.EBUSINESSID);
        params.put("RequestType", "2006");
        String dataSign = encrypt(requestData, OmsConstant.APPKEY, "UTF-8");
        params.put("DataSign", urlEncoder(dataSign, "UTF-8"));
        params.put("DataType", "2");

        String result = HttpClientUtils.doHttpPost(params, OmsConstant.KDNIAO_URI);

        // 根据公司业务处理返回的信息......

        return result;
    }

    /***
     * 打印电子面单
     * 
     * @param data
     * @return
     * @throws Exception
     */
    public static String orderOnlineByJson(RequestData data) throws Exception {
        String requestData = objectMapper.writeValueAsString(data);
        Map<String, String> params = new HashMap<String, String>();
        params.put("RequestData", urlEncoder(requestData, "UTF-8"));
        params.put("EBusinessID", OmsConstant.EBUSINESSID);
        params.put("RequestType", "1007");
        String dataSign = encrypt(requestData, OmsConstant.APPKEY, "UTF-8");
        params.put("DataSign", urlEncoder(dataSign, "UTF-8"));
        params.put("DataType", "2");
        return HttpClientUtils.doHttpPost(params, OmsConstant.KDNIAO_ONLINE_URI);
    }

    /***
     * 即时查询物流
     * 
     * @param expCode
     * @param expNo
     * @return
     * @throws Exception
     */
    public static String query(String expCode, String expNo) throws Exception {
        String requestData = "{'OrderCode':'','ShipperCode':'" + expCode + "','LogisticCode':'" + expNo + "'}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("RequestData", urlEncoder(requestData, "UTF-8"));
        params.put("EBusinessID", OmsConstant.EBUSINESSID);
        params.put("RequestType", "1002");
        String dataSign = encrypt(requestData, OmsConstant.APPKEY, "UTF-8");
        params.put("DataSign", urlEncoder(dataSign, "UTF-8"));
        params.put("DataType", "2");
        return HttpClientUtils.doHttpPost(params, OmsConstant.KDNIAO_URI);
    }

    /**
     * MD5加密
     * 
     * @param str
     *            内容
     * @param charset
     *            编码方式
     * @throws Exception
     */
    @SuppressWarnings("unused")
    private static String MD5(String str, String charset) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes(charset));
        byte[] result = md.digest();
        StringBuffer sb = new StringBuffer(32);
        for (int i = 0; i < result.length; i++) {
            int val = result[i] & 0xff;
            if (val <= 0xf) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(val));
        }
        return sb.toString().toLowerCase();
    }

    /**
     * base64编码
     * 
     * @param str
     *            内容
     * @param charset
     *            编码方式
     * @throws UnsupportedEncodingException
     */
    private static String base64(String str, String charset) throws UnsupportedEncodingException {
        String encoded = base64Encode(str.getBytes(charset));
        return encoded;
    }

    @SuppressWarnings("unused")
    private static String urlEncoder(String str, String charset) throws UnsupportedEncodingException {
        String result = URLEncoder.encode(str, charset);
        return result;
    }

    /**
     * 电商Sign签名生成
     * 
     * @param content
     *            内容
     * @param keyValue
     *            Appkey
     * @param charset
     *            编码方式
     * @throws UnsupportedEncodingException
     *             ,Exception
     * @return DataSign签名
     */
    @SuppressWarnings("unused")
    private static String encrypt(String content, String keyValue, String charset) throws UnsupportedEncodingException, Exception {
        if (keyValue != null) {
            return base64(MD5(content + keyValue, charset), charset);
        }
        return base64(MD5(content, charset), charset);
    }

    private static char[] base64EncodeChars = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/' };

    public static String base64Encode(byte[] data) {
        StringBuffer sb = new StringBuffer();
        int len = data.length;
        int i = 0;
        int b1, b2, b3;
        while (i < len) {
            b1 = data[i++] & 0xff;
            if (i == len) {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[(b1 & 0x3) << 4]);
                sb.append("==");
                break;
            }
            b2 = data[i++] & 0xff;
            if (i == len) {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
                sb.append(base64EncodeChars[(b2 & 0x0f) << 2]);
                sb.append("=");
                break;
            }
            b3 = data[i++] & 0xff;
            sb.append(base64EncodeChars[b1 >>> 2]);
            sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
            sb.append(base64EncodeChars[((b2 & 0x0f) << 2) | ((b3 & 0xc0) >>> 6)]);
            sb.append(base64EncodeChars[b3 & 0x3f]);
        }
        return sb.toString();
    }
}
