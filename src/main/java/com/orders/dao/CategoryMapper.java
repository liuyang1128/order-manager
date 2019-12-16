package com.orders.dao;

import com.orders.pojo.bo.IdAndNameBo;
import com.orders.pojo.po.Category;
import com.orders.pojo.vo.CategoryVo;
import com.orders.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper extends MyMapper<Category> {
	
	List<CategoryVo>  getCategoryListBySuperId(@Param("superId") Long superId, @Param("storeId") Long storeId);
	
	/*
	* @Author zhangxin_an 
	* @Date 2018/4/30 17:37
	* @Params [superId, storeId]  
	* @Return java.util.List<java.lang.Long>  
	* @Description:获取最小子类id
	*/  
//	List<Long>  getCategoryIdListBySuperId(@Param("superId") Long superId, @Param("storeId") Long storeId);
	
	int setDeleteStatus(long id);
	
	List<IdAndNameBo> selectAllIdAndName(Long storeId);
}