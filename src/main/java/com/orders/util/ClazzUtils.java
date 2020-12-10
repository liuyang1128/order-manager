package com.orders.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: java类反射工具类
 * @Author: liuyang
 * @Date: 2020/10/21 13:57
 */
public class ClazzUtils {

    /**
     * @Description 根据类信息获取属性集合
     * @Param clazz
     * @Return java.util.Map<java.lang.String,java.lang.Class<?>>
     * @Author liuyang
     * @Date 2020/10/21 14:03
     */
    public static Map<String, Class<?>> getClazzAllFields(Class<?> clazz) {
        Map<String, Class<?>> mapField = Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toMap(Field::getName, Field::getType));
        Class<?> tempClass = clazz.getSuperclass();
        while (tempClass != null) {//当父类为null的时候说明到达了最上层的父类(Object类).
            mapField.putAll(Arrays.stream(tempClass.getDeclaredFields()).collect(Collectors.toMap(Field::getName, Field::getType)));
            tempClass = tempClass.getSuperclass(); //得到父类,然后赋给自己
        }
        return mapField;
    }

}
