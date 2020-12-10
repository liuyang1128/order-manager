package com.orders.dao;

import com.orders.pojo.po.StorageOrderDetail;
import com.orders.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StorageOrderDetailMapper extends MyMapper<StorageOrderDetail> {
	List<StorageOrderDetail> getStorageOrderDetailByOrderId(Long id);

//	int insertStorageDetail(StorageDetailDto storageDetailDto);
	
//	List<StorageOrderVo> getStorageOrderList(@Param("storeId") String storeId);

}