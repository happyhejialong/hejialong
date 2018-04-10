/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.common;

import java.io.Serializable;

import com.ycxy.wdgj.dto.PageInfo;

/**
 * @since 2018年2月12日 上午11:38:10
 * @author hjl
 *
 */
public class OmsResponse<T> implements Serializable {
    private static final Integer SUCCESS_CODE = 200;
    private static final String SUCCESS_MSG = "SUCCESS";
    private Integer code = SUCCESS_CODE;
    private String msg = SUCCESS_MSG;
    private Result result = new Result();

    public class Result {
        T data;
        PageInfo pageInfo;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public PageInfo getPageInfo() {
            return pageInfo;
        }

        public void setPageInfo(PageInfo pageInfo) {
            this.pageInfo = pageInfo;
        }

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
