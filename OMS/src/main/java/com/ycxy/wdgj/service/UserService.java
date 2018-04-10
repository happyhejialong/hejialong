/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.service;

import com.ycxy.wdgj.common.exception.OmsException;
import com.ycxy.wdgj.model.User;

/**
 * @since 2018年2月12日 下午4:40:42
 * @author hjl
 *
 */
public interface UserService {

    /**
     * @param username
     * @param password
     * @param valid
     */
    User login(String username, String password, String valid) throws Exception;

    /***
     * 注册用户
     * 
     * @param user
     */
    void register(User user, String validate) throws OmsException;

    /****
     * 发送验证码
     * 
     * @param phone
     * @return 验证码，用作后续比较
     */
    String sendValidate(String phone) throws Exception;

    /**
     * 查询用户通过username
     * 
     * @param username
     * @return
     */
    User findUserByUsername(String username);

}
