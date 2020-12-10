package com.orders.dao;

import com.orders.pojo.po.DeliveryOrder;
import com.orders.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface DeliveryOrderMapper extends MyMapper<DeliveryOrder> {
}