/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.common.exception;

/**
 * @since 2018年2月12日 下午1:40:44
 * @author hjl
 *
 */
public class OmsException extends Exception {
    public OmsException() {

    }

    public OmsException(String errorMsg) {
        super(errorMsg);
    }
}
