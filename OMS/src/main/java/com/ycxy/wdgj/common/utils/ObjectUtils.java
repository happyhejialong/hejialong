/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.common.utils;

import java.util.List;

/**
 * @since 2018年2月12日 下午1:43:14
 * @author hjl
 *
 */
public class ObjectUtils {
    public static boolean isEmpty(Object[] arr) {
        return arr == null || arr.length == 0;
    }

    public static <T> boolean isEmpty(List<T> arrList) {
        return arrList == null || arrList.size() == 0;
    }

    public static boolean isEmpty(Object obj) {
        return obj == null;
    }

    public static boolean isEmpty(Object obj1, Object obj2) {
        return obj1 == null && obj2 == null;

    }
}
