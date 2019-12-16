package com.orders.service;

/*
*Author:zhangxin_an
*Description:
*Data:Created in 16:23 2018/4/24
*/

import com.orders.OrdersApplication;
import com.orders.pojo.vo.CategoryVo;
import com.orders.service.impl.CategoryServiceIMpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrdersApplication.class)
public class CategoryServiceTest {
	
	@Autowired
    CategoryServiceIMpl categoryService;
	
	@Test
	public void testCategory(){
		List<CategoryVo> categoryVos =  categoryService.getCategoryList(0);
		categoryVos.forEach(categoryVo -> {
			System.out.println(categoryVo.getCategoryName());
		});
	}
	
}
