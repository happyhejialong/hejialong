package com.ycxy.wdgj.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtils {
    /***
     * 模拟Http POST请求
     * 
     * @param params
     * @return
     * @throws Exception
     */
    public static String doHttpPost(Map<String, String> params, String url) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        for (Entry<String, String> entry : params.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
            pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairs);
        httpPost.setEntity(entity);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        HttpResponse response = httpClient.execute(httpPost);
        String result = EntityUtils.toString(response.getEntity());
        return result;
    }

    /***
     * post raw
     * 
     * @param params
     * @param url
     * @return
     * @throws Exception
     */
    public static String doHttpPost1(String params, String url) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        EntityBuilder builder = EntityBuilder.create();
        builder.setText(params);
        httpPost.setEntity(builder.build());
        HttpResponse response = httpClient.execute(httpPost);
        String result = EntityUtils.toString(response.getEntity());
        return result;
    }

    public static String doHttpGet(String url) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");
        HttpResponse response = httpClient.execute(httpGet);
        String result = EntityUtils.toString(response.getEntity());
        return result;
    }
}
