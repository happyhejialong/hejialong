/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.common.utils;

/**
 * @since 2018年2月22日 下午2:40:51
 * @author hjl
 *
 */
public class LimitClauseUtils {
    public static String limit(int index, int num) {
        return "limit " + index + "," + num;
    }
}
