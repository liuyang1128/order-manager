package com.orders.controller;

import com.orders.common.ServerResponse;
import com.orders.pojo.dto.UpdateStoreDto;
import com.orders.pojo.po.Store;
import com.orders.service.StoreService;
import com.orders.shiro.JWTUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zc
 * @description:商店控制器
 * @date: 2018/4/15
 */
@Api(tags = "店铺模块")
@RestController
public class StoreController {

    @Autowired
    private StoreService storeService;

    /**
     * @Author zc
     * @Date 2018/4/20 下午6:58
     * @Param []
     * @Return ServerResponse<Store>
     * @Description: 获取商店信息
     */
    @GetMapping("/store")
    @ApiOperation(value = "获取商店信息")
    public ServerResponse<Store> getStoreInfo() {
        Store storeInfo = storeService.getStoreInfoById(JWTUtil.getStoreId());
        return ServerResponse.createBySuccess(storeInfo);
    }


    /**
     * @Author zc
     * @Date 2018/4/20 下午6:58
     * @Param []
     * @Return ServerResponse<Store>
     * @Description: 获取商店信息
     */
    @RequiresPermissions("store:edit")
    @PutMapping("/store")
    @ApiOperation(value = "修改商店信息")
    public ServerResponse<Store> updateStoreInfo(UpdateStoreDto storeDto) {
        Store store = storeService.updateStore(JWTUtil.getStoreId(), storeDto);
        return ServerResponse.createBySuccess(store);
    }
}
