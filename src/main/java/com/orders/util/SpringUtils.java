package com.orders.util;

import org.springframework.context.ApplicationContext;

/**
 * @Description: Spring 上下文工具类
 * @Author Martin
 * @Date 2020/7/13 16:09
 */
public final class SpringUtils {

    private static ApplicationContext ctx = null;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringUtils.ctx = applicationContext;
    }

    /**
     * @Description 根据 name 获取 Bean
     * @param name
     * @return java.lang.Object
     * @author Martin
     * @Date 2020/7/13 16:19
     */
    public static Object getBean(String name) {
        return ctx.getBean(name);
    }

    /**
     * @Description 通过 class 获取 Bean
     * @Param clazz
     * @Return T
     * @Author Martin
     * @Date 2020/7/13 16:19
     */
    public static <T> T getBean(Class<T> clazz) {
        return ctx.getBean(clazz);
    }

    /**
     * @Description 通过name,以及Clazz返回指定的Bean
     * @param name
     * @param clazz
     * @return T
     * @author Martin
     * @Date 2020/7/13 16:19
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return ctx.getBean(name, clazz);
    }
}
