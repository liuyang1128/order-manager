package com.orders.service;

import com.orders.common.PageModel;
import com.orders.pojo.dto.DeliveryDto;
import com.orders.pojo.po.SaleOrder;

/**
 * Author: zc
 * Date: 2018/5/2
 * Description:出库
 */
public interface DeliveryService {
    Long deliverGoods(DeliveryDto deliveryDto);

    void sendEmail(Long saleOrderId);

    PageModel<SaleOrder> getUnSendOrder(PageModel pageModel);

}
