package com.orders.dao;

import com.orders.pojo.po.Permission;
import com.orders.pojo.vo.PermissionMenuVo;
import com.orders.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface PermissionMapper extends MyMapper<Permission> {

    List<Permission> findAddPermission(Long userId);

    List<PermissionMenuVo> findPermissionMenu(Long userId);
}