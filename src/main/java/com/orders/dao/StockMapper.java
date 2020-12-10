package com.orders.dao;

import com.orders.pojo.bo.ProductStockBo;
import com.orders.pojo.bo.StockBo;
import com.orders.pojo.po.Stock;
import com.orders.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface StockMapper extends MyMapper<Stock> {
	List<StockBo> getNearDaysProduct(@Param("days") Integer days, @Param("storeId") Long storeId);
	
	List<ProductStockBo> getLowCountProductsList(@Param("numbers") Integer numbers, @Param("storeId") Long storeId);

	List<StockBo> getStockBoByPid(Long pid);
}