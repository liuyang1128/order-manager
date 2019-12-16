package com.orders.service;


import com.orders.common.ServerResponse;
import com.orders.pojo.dto.RoleDto;
import com.orders.pojo.vo.RolePermissionVo;
import org.springframework.cache.annotation.CacheEvict;

import java.util.List;

/**
 * @author: zc
 * @description:
 * @date: 2018/4/14
 */
public interface RoleService {
    Boolean postRole(RoleDto roleDto);

    List<RolePermissionVo> getRoleListByStore(Long storeId);

    void clearRoleListCache(Long store_id);

    ServerResponse changeRole(String employeeUserName, List<Long> roles);

    ServerResponse changePermission(Long roleId, List<Long> permissions);
}
