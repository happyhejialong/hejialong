/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ycxy.wdgj.common.OmsResponse;
import com.ycxy.wdgj.common.exception.OmsException;
import com.ycxy.wdgj.common.utils.BindingResultHelper;
import com.ycxy.wdgj.model.User;
import com.ycxy.wdgj.service.UserService;
import com.ycxy.wdgj.valid.insert;
import com.ycxy.wdgj.valid.select;

/**
 * @since 2018年2月12日 下午4:37:58
 * @author hjl
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public OmsResponse<User> login(@Validated(value = { select.class }) User user, String validate, BindingResult result, HttpSession session) {
        OmsResponse<User> or = new OmsResponse<User>();
        try {
            BindingResultHelper.cacheExceptions(result);
            user = userService.login(user.getUsername(), user.getPassword(), validate);
            session.setAttribute("user", user);
            or.getResult().setData(user);
        } catch (Exception e) {
            e.printStackTrace();
            or.setCode(e.hashCode());
            or.setMsg(e.getMessage());
        }
        return or;
    }

    /***
     * 用户注册
     * 
     * @param user
     * @param validate
     * @param result
     * @return
     */
    @PostMapping("/register")
    public OmsResponse<User> register(@Validated(value = { insert.class }) User user, String validate, BindingResult result, HttpSession session) {
        OmsResponse<User> or = new OmsResponse<User>();
        try {
            BindingResultHelper.cacheExceptions(result);
            String valid = (String) session.getAttribute("validate");
            if (StringUtils.isEmpty(valid)) {
                throw new OmsException("短信验证码为发送/已过期");
            }
            if (!validate.equals(valid)) {
                throw new OmsException("短信验证码输入错误");
            }
            userService.register(user, validate);
        } catch (Exception e) {
            e.printStackTrace();
            or.setCode(e.hashCode());
            or.setMsg(or.getMsg());
        }
        return or;
    }

    /***
     * 发送短信验证码
     * 
     * @param phone
     * @return
     */
    @GetMapping("/sendValidate")
    public OmsResponse<Object> sendValidate(String phone, HttpSession session) {
        OmsResponse<Object> or = new OmsResponse<Object>();
        try {
            String validate = userService.sendValidate(phone);
            session.setAttribute("validate", validate);
            // 设置5分钟过期
            session.setMaxInactiveInterval(300);
        } catch (Exception e) {
            e.printStackTrace();
            or.setCode(e.hashCode());
            or.setMsg(e.getMessage());
        }
        return or;
    }
}
