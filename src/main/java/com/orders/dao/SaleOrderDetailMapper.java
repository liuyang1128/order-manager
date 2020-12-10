package com.orders.dao;

import com.orders.pojo.po.SaleOrderDetail;
import com.orders.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface SaleOrderDetailMapper extends MyMapper<SaleOrderDetail> {
}