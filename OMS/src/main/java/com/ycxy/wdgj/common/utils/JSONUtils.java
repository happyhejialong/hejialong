/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.common.utils;

import com.alibaba.fastjson.JSON;
import com.ycxy.wdgj.common.exception.OmsException;

/**
 * @since 2018年2月12日 下午1:24:58
 * @author hjl
 *
 */
public class JSONUtils {
    private static JSONUtils jsonUtils;

    private JSONUtils() {
    }

    public static JSONUtils getInstance() {
        return jsonUtils;
    }

    public static <T> T converStrToObject(String jsonStr, Class<T> clazz) throws Exception {
        if ("{}".equals(jsonStr)) {
            throw new OmsException("传入json不为空");
        }
        if (ObjectUtils.isEmpty(clazz)) {
            throw new OmsException("请输入Class字节码");
        }
        T t = JSON.parseObject(jsonStr, clazz);
        return t;
    }
}
