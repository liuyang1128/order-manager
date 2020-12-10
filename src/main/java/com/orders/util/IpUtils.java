package com.orders.util;

import com.orders.constant.ErrorCode;
import com.orders.exception.SystemException;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * @Description: IP地址工具类
 * @Author Regan
 * @Date 2020/6/23 11:17
 */
public class IpUtils {

    /**
     * @Description 根据HttpServletRequest获取IP地址
     * @Param request
     * @Return java.lang.String
     * @Author Regan
     * @Date 2020/6/23 11:17
     */
    public static String getIp(HttpServletRequest request) {
        if (request == null) {
            throw new SystemException(ErrorCode.PARAM_IS_NULL, "获取IP,参数【request】为空");
        }
        String ipString = request.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getRemoteAddr();
        }

        // 多个路由时，取第一个非unknown的ip
        final String[] arr = ipString.split(",");
        for (final String str : arr) {
            if (!"unknown".equalsIgnoreCase(str)) {
                ipString = str;
                break;
            }
        }
        return ipString;
    }

    /**
     * @Description 根据IP地址获取MAC地址
     * @Param ip
     * @Return java.lang.String
     * @Author Regan
     * @Date 2020/6/23 11:18
     */
    public static String getMACAddress(String ip) throws IOException {
        String str = "";
        String macAddress = "";
        Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);
        InputStreamReader ir = new InputStreamReader(p.getInputStream());
        LineNumberReader input = new LineNumberReader(ir);
        for (int i = 1; i < 100; i++) {
            str = input.readLine();
            if (str != null) {
                if (str.indexOf("MAC Address") > 1) {
                    macAddress = str.substring(str.indexOf("MAC Address") + 14, str.length());
                    break;
                }
            }
        }
        return macAddress;
    }
}
