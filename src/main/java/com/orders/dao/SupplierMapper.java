package com.orders.dao;

import com.orders.pojo.bo.IdAndNameBo;
import com.orders.pojo.po.Supplier;
import com.orders.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface SupplierMapper extends MyMapper<Supplier> {
	List<Supplier> getSupplierByStoreId(Long storeId);
	
	IdAndNameBo getIdAndName(Long id);
}