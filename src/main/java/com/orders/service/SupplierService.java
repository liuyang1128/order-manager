package com.orders.service;

import com.orders.common.PageModel;
import com.orders.common.ServerResponse;
import com.orders.pojo.dto.SupplierDto;
import com.orders.pojo.po.Supplier;

/*
*Author:zhangxin_an
*Description:
*Data:Created in 13:53 2018/4/24
*/
public interface SupplierService {
	
	PageModel<Supplier> getSupplierList(PageModel pageModel);
	
	Supplier getSupplierById(Long whId);

    ServerResponse updateSupplier(Long id, SupplierDto SupplierDto);
	
	ServerResponse deleteSupplierById(Long whId);
	
	
	ServerResponse addSupplier(SupplierDto SupplierDto);
	
}
