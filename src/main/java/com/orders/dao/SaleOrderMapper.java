package com.orders.dao;

import com.orders.pojo.bo.CustomerDebtBo;
import com.orders.pojo.dto.SaleOrderDto;
import com.orders.pojo.po.SaleOrder;
import com.orders.pojo.vo.ProductCountMapVo;
import com.orders.pojo.vo.SaleOrderVo;
import com.orders.pojo.vo.SaleTotalVo;
import com.orders.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
public interface SaleOrderMapper extends MyMapper<SaleOrder> {
    List<CustomerDebtBo> getCustomerDebtBo(@Param("storeId") Long storeId, @Param("condition") String condition);

//    List<CustomerDebtGroupBo> getCustomerDebtGroupBo(@Param("storeId") Long storeId, @Param("condition") String condition);

    SaleTotalVo getSaleTotal(@Param("storeId") Long storeId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    List<SaleOrderVo> getSaleOrderVo(@Param("storeId") Long storeId, @Param("saleOrderDto") SaleOrderDto saleOrderDto);

    List<ProductCountMapVo> getSaleTotalProductCount(@Param("storeId") Long storeId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    List<SaleOrder> getUnSendOrder(Long storeId);
}