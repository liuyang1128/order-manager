package com.orders.service.impl;

import com.orders.dao.StoreMapper;
import com.orders.exception.IllegalException;
import com.orders.pojo.dto.UpdateStoreDto;
import com.orders.pojo.po.Store;
import com.orders.service.StoreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zc
 * @description:
 * @date: 2018/4/15
 */
@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreMapper storeMapper;

    @Override
    public Store getStoreInfoById(Long storeId) {
        if (storeId == null) {
            throw new IllegalException("商店Id不能为空");
        }
        return storeMapper.selectByPrimaryKey(storeId);
    }

    @Override
    public Store updateStore(Long store_id, UpdateStoreDto updateStoreDto) {
        Store store = new Store();
        store.setId(store_id);
        BeanUtils.copyProperties(updateStoreDto, store);
        int i = storeMapper.updateByPrimaryKeySelective(store);
        if (i <= 0) {
            throw new IllegalException("更新失败");
        }
        Store storeInfo = storeMapper.selectByPrimaryKey(store_id);
        return storeInfo;
    }

}
