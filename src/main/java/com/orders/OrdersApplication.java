package com.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @SpringbootApplication 相当于 @Configuration, @EnableAutoConfiguration 和 @ComponentScan 并具有他们的默认属性值
 */

@SpringBootApplication
@EnableTransactionManagement
@EnableAsync
@EnableScheduling
@EnableCaching//启用缓存，这个注解很重要；
public class OrdersApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrdersApplication.class, args);
    }
}
