package com.orders.service;

import com.orders.common.PageModel;
import com.orders.common.ServerResponse;
import com.orders.pojo.bo.IdAndNameBo;
import com.orders.pojo.dto.WarehouseDTO;
import com.orders.pojo.vo.WarehouseVo;

import java.util.List;

/*
*Author:zhangxin_an
*Description:
*Data:Created in 9:55 2018/4/24
*/
public interface WareHouseService {
	
	PageModel<WarehouseVo> getWarehouseList(PageModel pageModel);
	
	WarehouseVo getWarehouseById(Long whId);
	
	ServerResponse updateWarehouse(WarehouseDTO warehouseDTO);
	
	ServerResponse deleteWarehouseById(Long whId);
	
	
	ServerResponse addWarehouse(WarehouseDTO warehouseDTO);
	
	
	List<IdAndNameBo> getWarehouseNameList();
}
