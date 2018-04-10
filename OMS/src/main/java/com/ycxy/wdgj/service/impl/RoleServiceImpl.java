/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycxy.wdgj.common.exception.OmsException;
import com.ycxy.wdgj.common.utils.ObjectUtils;
import com.ycxy.wdgj.dao.RoleMapper;
import com.ycxy.wdgj.service.RoleService;
import com.ycxy.wdgj.taobao.domain.Role;
import com.ycxy.wdgj.taobao.domain.RoleExample;

/**
 * @since 2018年3月8日 下午3:18:32
 * @author hjl
 *
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    /****
     * 查询订单列表信息
     * 
     * @param userId
     *            用户id
     * 
     */
    @Override
    public List<Role> list(Integer userId) {
        RoleExample example = new RoleExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<Role> roleList = roleMapper.selectByExample(example);
        return roleList;
    }

    /***
     * 增加用户权限
     * 
     * @param roleList
     * @throws Exception
     */
    @Override
    public void add(List<Role> roleList) throws Exception {
        if (ObjectUtils.isEmpty(roleList)) {
            return;
        }
        for (int i = 0; i < roleList.size(); i++) {
            int insertRoleFlag = roleMapper.insert(roleList.get(i));
            if (insertRoleFlag != 1) {
                throw new OmsException("插入用户权限失败");
            }
        }
    }

}
