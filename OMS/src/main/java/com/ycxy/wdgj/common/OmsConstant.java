package com.ycxy.wdgj.common;

public class OmsConstant {
    public static final Byte DELETE = 1;
    // 短信发送地址
    public static final String MESSAGE_URL = "https://api.mysubmail.com/message/send";
    // 短信模板内容
    public static final String MESSAGE_INFO = "【OMS】你好，你的验证码是:";
    // 快递鸟用户ID
    public static final String EBUSINESSID = "1322204";
    // API KEY
    public static final String APPKEY = "16468a79-5802-4d8c-bc4c-140567e98c1c";
    // 快递鸟 查询物流地址
    public static final String KDNIAO_URI = "http://api.kdniao.cc/Ebusiness/EbusinessOrderHandle.aspx";
    // 快递鸟生成电子面单
    public static final String KDNIAO_ONLINE_URI = "http://testapi.kdniao.cc:8081/api/Eorderservice";
    // 高德地图key
    public static final String AMAP_KEY = "ce18a16b1a97bd253d0efb06f1c247c4";
    // 高德地图查询地址uri
    public static final String AMAP_URI = "http://restapi.amap.com/v3/config/district?subdistrict=1";

    /** Fieds */
    public static final String FIELDS = "o2o_delivery,customer_email,o2o_shop_name,o2o_shop_id,order_tax_fee,seller_nick,buyer_nick,title,type,created,sid,tid,seller_rate,buyer_rate,status,payment,discount_fee,adjust_fee,post_fee,total_fee,pay_time,end_time,modified,consign_time,buyer_obtain_point_fee,point_fee,real_point_fee,received_payment,commission_fee,pic_path,num_iid,num_iid,num,price,cod_fee,cod_status,shipping_type,receiver_name,receiver_state,receiver_city,receiver_district,receiver_address,receiver_zip,receiver_mobile,receiver_phone,orders.title,orders.pic_path,orders.price,orders.num,orders.divide_order_fee,orders.iid,orders.num_iid,orders.consign_time,orders.part_mjz_discount,orders.sku_id,orders.refund_status,orders.status,orders.oid,orders.total_fee,orders.payment,orders.discount_fee,orders.adjust_fee,orders.sku_properties_name,orders.logistics_company,orders.item_meal_name,orders.buyer_rate,orders.seller_rate,orders.outer_iid,orders.invoice_no,orders.end_time,orders.outer_sku_id,orders.refund_id,orders.seller_type,tid,payment,seller_rate,post_fee,receiver_name,receiver_state,receiver_address,receiver_mobile,receiver_phone,consign_time,received_payment,receiver_country,receiver_town,num,num_iid,status,title,price,discount_fee,orders,service_orders";

}
