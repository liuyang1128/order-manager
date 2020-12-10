package com.orders.dao;

import com.orders.pojo.po.Store;
import com.orders.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface StoreMapper extends MyMapper<Store> {
}