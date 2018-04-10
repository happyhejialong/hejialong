package com.ycxy.wdgj.common.utils;

import java.util.Map;

import com.ycxy.wdgj.common.HttpClientUtils;

public class TaoBaoClient {
    private String appKey;
    private String appSecret;
    private String method;
    private String serverUri;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getServerUri() {
        return serverUri;
    }

    public void setServerUri(String serverUri) {
        this.serverUri = serverUri;
    }

    public TaoBaoClient(String appKey, String appSecret, String method, String serverUri) {
        super();
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.method = method;
        this.serverUri = serverUri;
    }

    public String doHttpPost(Map<String, String> params) throws Exception {
        params.put("app_key", this.appKey);
        params.put("method", this.method);
        params.put("sign", SignUtils.signTopRequest(params, this.appSecret, "md5"));
        return HttpClientUtils.doHttpPost(params, this.serverUri);
    }
}
