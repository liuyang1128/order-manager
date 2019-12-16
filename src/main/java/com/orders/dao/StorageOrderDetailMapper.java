package com.orders.dao;

import com.orders.pojo.po.StorageOrderDetail;
import com.orders.util.MyMapper;

import java.util.List;

public interface StorageOrderDetailMapper extends MyMapper<StorageOrderDetail> {
	List<StorageOrderDetail> getStorageOrderDetailByOrderId(Long id);

//	int insertStorageDetail(StorageDetailDto storageDetailDto);
	
//	List<StorageOrderVo> getStorageOrderList(@Param("storeId") String storeId);

}