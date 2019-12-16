package com.orders.service;

import com.orders.pojo.dto.DeliveryDto;
import com.orders.pojo.dto.PlaceOrderItemDto;

import java.util.List;

/**
 * Author: zc
 * Date: 2018/5/2
 * Description:一些特殊服务
 */
public interface OtherService {
    void checkAndCutStock(List<PlaceOrderItemDto> placeOrderItemDtos);

    void checkDelivery(DeliveryDto deliveryDto);

}
