/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.ycxy.wdgj.common.OmsConstant;
import com.ycxy.wdgj.common.exception.OmsException;
import com.ycxy.wdgj.common.utils.CollectionUtils;
import com.ycxy.wdgj.common.utils.LimitClauseUtils;
import com.ycxy.wdgj.common.utils.MathUtils;
import com.ycxy.wdgj.common.utils.MessageSend;
import com.ycxy.wdgj.controller.WebSocketController;
import com.ycxy.wdgj.dao.UserMapper;
import com.ycxy.wdgj.model.User;
import com.ycxy.wdgj.model.UserExample;
import com.ycxy.wdgj.service.UserService;

/**
 * @since 2018年2月12日 下午4:40:55
 * @author hjl
 *
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     * 
     * @param username
     *            用户名
     * @param password
     *            密码
     * @param valid
     *            验证码
     */
    @Override
    public User login(String username, String password, String validate) throws Exception {
        // TODO Auto-generated method stub

        // 先校验验证码

        // 校验用户名密码是否正确
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        System.out.println(userMapper.selectByExample(userExample));
        User user = CollectionUtils.getFirst(userMapper.selectByExample(userExample));
        new WebSocketController().sendMessage("hahaha");
        if (ObjectUtils.isEmpty(user)) {
            throw new OmsException("用户名或密码错误");
        }
        return user;
    }

    /***
     * 注册用户
     * 
     * @param user
     * @throws OmsException
     */
    @Override
    public void register(User user, String validate) throws OmsException {
        // 校验验证码

        int insertUserFlag = userMapper.insertSelective(user);
        if (insertUserFlag != 1) {
            throw new OmsException("用户注册标志位不为1");
        }
    }

    @Override
    public String sendValidate(String phone) throws Exception {
        int validate = MathUtils.getRandomNum4B();
        MessageSend.send(OmsConstant.MESSAGE_INFO + validate, phone);
        return String.valueOf(validate);
    }

    /**
     * 查询用户通过username
     * 
     * @param username
     * @return
     */
    @Override
    public User findUserByUsername(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        userExample.setLimitByClause(LimitClauseUtils.limit(0, 1));
        return CollectionUtils.getFirst(userMapper.selectByExample(userExample));
    }

}
