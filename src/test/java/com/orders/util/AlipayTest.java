package com.orders.util;

import com.alipay.api.AlipayApiException;
import com.orders.OrdersApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author: zc
 * Date: 2018/5/13
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrdersApplication.class)
public class AlipayTest {

    @Autowired
    private AliPayUtil payUtil;



    @Test
    public void testAlipAy(){
        payUtil.alipay("sdfghjklkjhgfgh","285057673967505711","124","1.00","还款");
    }
}
