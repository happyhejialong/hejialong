/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.service;

import java.util.List;

import com.ycxy.wdgj.taobao.domain.Role;

/**
 * @since 2018年3月8日 下午3:18:19
 * @author hjl
 *
 */
public interface RoleService {
    /****
     * 查询用户权限列表
     * 
     * @param userId
     * @return
     */
    public List<Role> list(Integer userId);

    /****
     * 增加用户权限
     */
    public void add(List<Role> roleList) throws Exception;
}
