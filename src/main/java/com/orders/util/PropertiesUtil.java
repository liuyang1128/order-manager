package com.orders.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by zc on 2018/4/10.
 * 配置文件读取工具
 */
@Slf4j
public class PropertiesUtil {

    private static Properties props;

    static {
        Properties defaultProps = new Properties();
        try {
            defaultProps.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties"),"UTF-8"));
        } catch (IOException e) {
            log.error("默认配置文件读取异常,异常信息:{}", e.getMessage(), e);
        }
        String active = defaultProps.get("spring.profiles.active").toString();
        String fileName = com.orders.util.StringUtils.append("application-", active, ".properties");
        props = new Properties();
        try {
            props.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName),"UTF-8"));
        } catch (IOException e) {
            log.error("生效配置文件读取异常,异常信息:{}", e.getMessage(), e);
        }
    }

    public static String getProperty(String key){
        String value = props.getProperty(key.trim());
        if(StringUtils.isBlank(value)){
            return null;
        }
        return value.trim();
    }

    public static String getProperty(String key,String defaultValue){

        String value = props.getProperty(key.trim());
        if(StringUtils.isBlank(value)){
            value = defaultValue;
        }
        return value.trim();
    }


}
