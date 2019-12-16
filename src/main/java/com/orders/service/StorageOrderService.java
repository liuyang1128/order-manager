package com.orders.service;

/*
*Author:zhangxin_an
*Description:
*Data:Created in 10:11 2018/5/3
*/

import com.orders.common.PageModel;
import com.orders.pojo.dto.StorageOrderDto;
import com.orders.pojo.vo.StorageOrderVo;

public interface StorageOrderService {
	
	void insertStorage(StorageOrderDto storageOrderDto);
	
	
	
	StorageOrderVo getStorageOrderByOrderNumber(String orderNumber);
	
	PageModel<StorageOrderVo> getStorageOrderList(PageModel pageModel);
	
	PageModel<StorageOrderVo> getStorageOrderListBySupplierId(PageModel pageModel, Long supplierId);
}
