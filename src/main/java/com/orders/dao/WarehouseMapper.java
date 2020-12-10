package com.orders.dao;

import com.orders.pojo.bo.IdAndNameBo;
import com.orders.pojo.po.Warehouse;
import com.orders.pojo.vo.WarehouseVo;
import com.orders.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface WarehouseMapper extends MyMapper<Warehouse> {

	List<WarehouseVo> getWarehouseByStoreId(Long storeId);
	
	IdAndNameBo getIdAndName(Long id);
	
	List<IdAndNameBo> getWarehouseNameList(Long storeId);
	
//	Warehouse getUserWarehouse(Long id);

}