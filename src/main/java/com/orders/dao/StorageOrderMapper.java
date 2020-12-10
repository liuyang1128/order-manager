package com.orders.dao;

import com.orders.pojo.po.StorageOrder;
import com.orders.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StorageOrderMapper extends MyMapper<StorageOrder> {
	
	StorageOrder getStorageOrderByOrderNumber(String orderNumber);
}