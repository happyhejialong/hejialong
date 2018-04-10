package com.ycxy.wdgj.taobao.request;

import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.ycxy.wdgj.common.utils.ObjectUtils;

public class BaseRequest {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String method;
    private String app_key;
    private String targetAppKey;
    private String sign_method = "md5";
    private String sign;
    private String session;
    private String timestamp = String.valueOf(new Date().getTime());
    private String format = "json";
    private String v = "2.0";
    private String partnerId;
    private String simplify;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getTargetAppKey() {
        return targetAppKey;
    }

    public void setTargetAppKey(String targetAppKey) {
        this.targetAppKey = targetAppKey;
    }

    public String getApp_key() {
        return app_key;
    }

    public void setApp_key(String app_key) {
        this.app_key = app_key;
    }

    public String getSign_method() {
        return sign_method;
    }

    public void setSign_method(String sign_method) {
        this.sign_method = sign_method;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getSimplify() {
        return simplify;
    }

    public void setSimplify(String simplify) {
        this.simplify = simplify;
    }

    /***
     * 设置部分默认值
     * 
     * @throws Exception
     * @throws IOException
     */
    public void setDefaultValue(String secret) throws Exception {
        this.setTimestamp(String.valueOf(new Date().getTime()));
        this.setV("2.0");
        this.setFormat("json");
        this.setSign_method("md5");
    }

    public Map<String, String> putBaseParams() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        Class clazz = BaseRequest.class;
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object obj = field.get(this);
            if (ObjectUtils.isEmpty(obj) || StringUtils.isEmpty(obj) || field.getName().equalsIgnoreCase("dateformat")) {
                continue;
            }
            params.put(field.getName().toLowerCase(), String.valueOf(obj));
        }
        return params;
    }
}
