package com.orders.service;

import com.orders.common.PageModel;
import com.orders.pojo.dto.ProductDto;
import com.orders.pojo.po.Product;
import com.orders.pojo.vo.ProductNearDayVo;
import com.orders.pojo.vo.ProductStockVo;
import com.orders.pojo.vo.ProductsVo;
import com.orders.pojo.vo.StockByBatchVo;

import java.util.List;

/*
*Author:zhangxin_an
*Description:
*Data:Created in 14:48 2018/4/30
*/
public interface ProductService {
	
	PageModel<ProductsVo> getProductsList(String condition, PageModel pageModel);
	
	
	PageModel<ProductsVo> getProductsListByCategory(Long categoryId, PageModel pageModel);

	ProductsVo getProductsListBybarCode(String barCode);
	
	Product getProduct(Long pId);

	void deleteProduct(Long pId);
	
	Product addProduct(ProductDto productDto);

	Product updateProduct(ProductDto productDto);
	
	PageModel<ProductNearDayVo> getNearDaysProduct(Integer days, PageModel pageModel);
	
	PageModel<ProductStockVo> getLowCountProduct(Integer numbers, PageModel pageModel);
	
	
	List<StockByBatchVo> getstockWithBatch(Long pid);
}
