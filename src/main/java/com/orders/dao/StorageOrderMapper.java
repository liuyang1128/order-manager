package com.orders.dao;

import com.orders.pojo.po.StorageOrder;
import com.orders.util.MyMapper;

public interface StorageOrderMapper extends MyMapper<StorageOrder> {
	
	StorageOrder getStorageOrderByOrderNumber(String orderNumber);
}