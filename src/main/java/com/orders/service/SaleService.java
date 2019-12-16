package com.orders.service;

import com.orders.common.PageModel;
import com.orders.pojo.dto.PaymentDto;
import com.orders.pojo.dto.PlaceOrderDto;
import com.orders.pojo.dto.PlaceOrderItemDto;
import com.orders.pojo.dto.SaleOrderDto;
import com.orders.pojo.vo.SaleOrderVo;
import com.orders.pojo.vo.PlaceOrderVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * Author: zc
 * Date: 2018/4/23
 * Description:
 */
public interface SaleService {
    PageModel<SaleOrderVo> getSaleOrderRecords(SaleOrderDto saleOrderDto, PageModel pageModel);

    SaleOrderVo getSaleOrderRecordOne(Long id);

    PlaceOrderVo placeOrder(Long storeId, Long seller, PlaceOrderDto placeOrderDto);

    void recordHotSale(List<PlaceOrderItemDto> placeOrderItemDtos);

    void recordCustomerScore(Long customerId, BigDecimal sumPrice);

    void confirmReceipt(Long saleOrderId);

    void closeOrder(Long saleOrderId,boolean isTsk);

    void payment(Long saleOrderId, PaymentDto paymentDto);
}
