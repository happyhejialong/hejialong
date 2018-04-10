/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @since 2018年2月12日 下午1:32:50
 * @author hjl
 *
 */
public class IdMakerUtils {
    public static SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");

    public static Long makeUniqueLong() {
        Long id = System.currentTimeMillis();
        return id;
    }

    public static String makeUniqueString() {
        String str = UUID.randomUUID().toString();
        return str;
    }

    public static String makeObjectId(String suffix) {
        String objectId = suffix + format.format(new Date()) + MathUtils.getRandomNum4B();
        return objectId;
    }
}
