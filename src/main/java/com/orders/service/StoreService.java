package com.orders.service;

import com.orders.pojo.dto.UpdateStoreDto;
import com.orders.pojo.po.Store;

/**
 * @author: zc
 * @description:
 * @date: 2018/4/15
 */
public interface StoreService {
    Store getStoreInfoById(Long storeId);

    Store updateStore(Long store_id, UpdateStoreDto updateStoreDto);
    
}
