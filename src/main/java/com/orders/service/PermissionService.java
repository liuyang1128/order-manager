package com.orders.service;

import com.orders.pojo.po.Permission;
import com.orders.pojo.vo.PermissionMenuVo;

import java.util.List;

/**
 * Author: zc
 * Date: 2018/4/20
 * Description:
 */
public interface PermissionService {
    List<Permission> findAddPermission(Long userId);

    void clearPermissionListCacheByUserId(Long userId);

    List<Permission> updatePermissionCacheByUserId(Long userId);

    List<PermissionMenuVo> getPermissionMenuByUserId(Long userId);
}
