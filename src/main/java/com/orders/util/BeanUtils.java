package com.orders.util;

import com.orders.constant.ErrorCode;
import com.orders.exception.BusinessException;
import com.orders.exception.SystemException;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.beans.BeanMap;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: Bean工具类
 * @Author Martin
 * @Date 2020/6/30 16:56
 */
public final class BeanUtils extends org.springframework.beans.BeanUtils {

    private BeanUtils() {}

    /**
     * @Description 实例化对象
     * @Param clazz
     * @Return T
     * @Author Martin
     * @Date 2020/3/15 12:22
     */
    public static <T> T newInstance(Class<?> clazz) {
        return (T) instantiateClass(clazz);
    }

    /**
     * @Description 实例化对象
     * @Param clazzName
     * @Return T
     * @Author Martin
     * @Date 2020/3/15 12:21
     */
    public static <T> T newInstance(String clazzName) {
        try {
            return newInstance(Class.forName(clazzName));
        } catch (final ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description copy 对象属性到另一个对象，默认不使用Convert
     * @Param object
     * @Param toClazz
     * @Return T
     * @Author Martin
     * @Date 2020/3/15 12:23
     */
    public static <T> T copy(Object object, Class<T> toClazz) {
        final BeanCopier copier = BeanCopier.create(object.getClass(), toClazz, false);
        final T toBean = newInstance(toClazz);
        copier.copy(object, toBean, null);
        return toBean;
    }

    /**
     * @Description 拷贝对象
     * @Param fromObject
     * @Param toObject
     * @Return void
     * @Author Martin
     * @Date 2020/3/15 12:23
     */
    public static void copy(Object fromObject, Object toObject) {
        final BeanCopier copier = BeanCopier.create(fromObject.getClass(), toObject.getClass(), false);
        copier.copy(fromObject, toObject, null);
    }

    /**
     * @Description 将对象装成 map 形式
     * @Param object
     * @Return java.util.Map
     * @Author Martin
     * @Date 2020/3/15 12:24
     */
    public static Map toMap(Object object) {
        return BeanMap.create(object);
    }

    /**
     * @Description Object 转换 Map<String, String> 对象
     * @Param obj
     * @Return java.util.Map<java.lang.String,java.lang.String>
     * @Author Martin
     * @Date 2020/3/14 10:28
     */
    public static Map<String, String> toMapString(final Object object) {
        if (object == null) {
            return Collections.emptyMap();
        }

        try {
            final Map<String, String> result = new HashMap<String, String>();
            final Map<String, Object> tempMap = toMap(object);
            tempMap.forEach((key,value) -> result.put(key, value== null ? "" : value.toString()));
            return result;
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.EXCUTE_METHOD_ERROR, "Object 转换 Map<String, String> 对象异常", e);
        }
    }

    /**
     * @Description 将 map 转为 bean
     * @Param beanMap
     * @Param pattern 日期类型转换格式 "yyyy-MM-dd"
     * @Param clazz
     * @Return T
     * @Author Martin
     * @Date 2020/3/15 12:24
     */
    public static <T> T toBean(Map<String, Object> beanMap, Class<T> clazz) {
        return toBean(beanMap, clazz, null);
    }

    /**
     * @Description 将 map 转为 bean
     * @Param beanMap
     * @Param pattern 日期类型转换格式 "yyyy-MM-dd"
     * @Param clazz
     * @Return T
     * @Author Martin
     * @Date 2020/3/15 12:24
     */
    public static <T> T toBean(Map<String, Object> beanMap, Class<T> clazz, String pattern) {
        final T bean = newInstance(clazz);
        final PropertyDescriptor[] beanPds = getPropertyDescriptors(clazz);
        for (final PropertyDescriptor propDescriptor : beanPds) {
            // 1.过滤class属性
            String propName = propDescriptor.getName();
            if (propName.equals("class")) {
                continue;
            }
            // 2.过滤属性是否存在
            if (!beanMap.containsKey(propName)) {
                continue;
            }
            // 3.过滤写入方法
            Method writeMethod = propDescriptor.getWriteMethod();
            if (null == writeMethod) {
                continue;
            }
            // 4.设置访问权限
            if (!writeMethod.isAccessible()) {
                writeMethod.setAccessible(true);
            }
            Object value = beanMap.get(propName);
            if (value != null) {
                setFieldValue(propDescriptor.getPropertyType(), propName, value, pattern);
            }
            try {
                writeMethod.invoke(bean, value);
            } catch (final Throwable e) {
                throw new BusinessException(ErrorCode.EXCUTE_METHOD_ERROR, "Map 转为 Bean 错误", e);
            }
        }
        return bean;
    }

    /**
     * @Description  Map 转为 Bean 字段类型转换
     * @Param fieldType
     * @Param fieldName
     * @Param value
     * @Param pattern 日期格式 "yyyy-MM-dd"
     * @Return Object 字段对应的value
     * @Author zhongmin
     * @Date 2020/3/15 12:24
     */
    public static Object setFieldValue(Class<?> fieldType, String fieldName, Object value, String pattern){
        if (null == fieldType) {
            throw new BusinessException(ErrorCode.EXCUTE_METHOD_ERROR, "Map 转为 Bean 字段匹配类型错误，参数【fieldType】为空");
        }
        if (null == fieldName) {
            throw new BusinessException(ErrorCode.EXCUTE_METHOD_ERROR, "Map 转为 Bean 字段匹配类型错误，参数【fieldType】为空");
        }
        if (null == value) {
            return null;
        }
        if (value instanceof String) {
            value = StringUtils.toString(value);
        }
        try {
            return fieldType.getConstructor(value.getClass());
        } catch (NoSuchMethodException e) {
            throw new SystemException(ErrorCode.EXCUTE_METHOD_ERROR, StringUtils.append("Map 转为 Bean 字段类型转换错误，属性【fieldName】=", fieldName), e);
        }
    }
}
