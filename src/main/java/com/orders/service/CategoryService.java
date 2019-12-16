package com.orders.service;

import com.orders.pojo.bo.IdAndNameBo;
import com.orders.pojo.dto.CategoryDto;
import com.orders.pojo.po.Category;
import com.orders.pojo.vo.CategoryVo;

import java.util.List;

/*
*Author:zhangxin_an
*Description:
*Data:Created in 15:57 2018/4/24
*/
public interface CategoryService {
	List<CategoryVo> getCategoryList(long supId);
	List<CategoryVo> getCategoryAllItems(long superId, Long storeId);
	
	int deleteCategory(long id);
	
	void addCategory(CategoryDto categoryDto);
	
	List<IdAndNameBo> getCategoryIdAndNameList();
	
	Category getCategoryById(Long cId);
}
