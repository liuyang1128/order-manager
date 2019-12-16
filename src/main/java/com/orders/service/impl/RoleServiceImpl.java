package com.orders.service.impl;

import com.orders.common.ServerResponse;
import com.orders.dao.PermissionMapper;
import com.orders.dao.RoleMapper;
import com.orders.dao.UserMapper;
import com.orders.exception.IllegalException;
import com.orders.pojo.dto.RoleDto;
import com.orders.pojo.po.Role;
import com.orders.pojo.po.User;
import com.orders.pojo.vo.RolePermissionVo;
import com.orders.service.PermissionService;
import com.orders.service.RoleService;
import com.orders.shiro.JWTUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author: zc
 * @description:角色
 * @date: 2018/4/14
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    @Lazy
    private PermissionService permissionService;

    @Override
//    @CachePut(value = "role_list", key = "#roleDto.getStoreId()")
    public Boolean postRole(RoleDto roleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDto, role);
        return roleMapper.insertSelective(role) > 0;
    }

    @Override
//    @Cacheable(value = "role_list", key = "#storeId")
    public List<RolePermissionVo> getRoleListByStore(Long storeId) {
        List<RolePermissionVo> rolePermission = roleMapper.findRolePermissionByRoleId(storeId);
        rolePermission.forEach(x->{
            int userCount = roleMapper.findUserCountByRoleId(storeId, x.getId());
            x.setUserCount(userCount);
        });
        return rolePermission;
    }

    @Override
//    @CacheEvict(value = "role_list", key = "#storeId")
    public void clearRoleListCache(Long store_id) {
    }




    /**
     * @Author zc
     * @Date 2018/4/18 下午2:09
     * @Param [userAndRoleDto]
     * @Return ServerResponse
     * @Description: 变更用户角色
     */
    @Transactional
    public ServerResponse changeRole(String employeeUserName, List<Long> roles) {

        //当前操作者的storeId
        Long storeId = JWTUtil.getStoreId();

        User user=new User();
        user.setUserName(employeeUserName);
        User employee = userMapper.selectOne(user);

        if (null == employee) {
            throw new IllegalException("无此用户");
        }

        if (ObjectUtils.notEqual(employee.getStoreId(), storeId)) {
            throw new AuthorizationException("无权修改");
        }

        userMapper.deleteAllRoleFromUser(employee.getId());

        if (CollectionUtils.isNotEmpty(roles)) {
            roles.forEach(roleId -> {
                if(roleId!=1&&roleId!=2){
                    userMapper.insertRoleToUser(employee.getId(), roleId, JWTUtil.getUserId());
                }
            });
        }

        //更新用户权限缓存
        permissionService.updatePermissionCacheByUserId(employee.getId());

        return ServerResponse.createBySuccessMessage("权限变更成功");
    }

    //FIXME 通用角色无权修改
    @Override
    public ServerResponse changePermission(Long roleId, List<Long> permissions) {
        return null;
    }


}
