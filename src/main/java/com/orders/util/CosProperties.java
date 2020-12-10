package com.orders.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description: COS 源配置
 * @Author admin
 * @Date 2020/12/10 13:51
 */
@Component
@ConfigurationProperties(prefix = "cos")
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
@Data
public class CosProperties {

    /**
     * 身份识别 ID
     * */
    private String secretId;

    /**
     * 身份密钥
     * */
    private String secretKey;

    /**
     *  域名中的地域信息 COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
     * */
    private String region;

    /**
     * bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
     * */
    private String bucketName;

    /**
     * cos 前缀
     * */
    private String serverHttpPrefix;

    /**
     * 头像前缀
     * */
    private String pathAvator;

    /**
     * 头像图片路径
     * */
    private String pathImg;

    /**
     *
     * */
    private String pathMoneyCode;

    /**
     *
     * */
    private String pathStoreLogo;

}
