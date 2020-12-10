package com.orders.util;

import com.orders.constant.ErrorCode;
import com.orders.exception.BusinessException;
import com.orders.exception.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串操作类
 * @author Martin
 * @Date 2019/07/30
 */
public final class StringUtils {

    private static final Logger logger = LoggerFactory.getLogger(StringUtils.class);

    public static final String NONE = "NONE";

    /**
     * 判断字符串时空
     * @param str
     * @return booealn
     * @author Martin
     * @Date 2019/07/30
     */
    public static boolean isEmpty(String str) {
        return null == str || "".equals(str) || "null".equals(str);
    }

    /**
     * 判断字符串不是空
     * @param str
     * @return booealn
     * @author Martin
     * @Date 2019/07/30
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 字符串拼接
     * @param obj
     * @return String str
     * @author Martin
     * @Date 2019/07/30
     */
    public static String append(Object... obj) {
        StringBuffer buffer = new StringBuffer();
        try {
            if (null == obj || obj.length == 0) {
                throw new BusinessException(ErrorCode.PARAM_IS_NULL, "参数【obj】为空");
            }
            for (Object o : obj) {
                buffer.append(o);
            }
        } catch (Throwable e) {
            throw new SystemException(ErrorCode.EXCUTE_METHOD_ERROR, "字符串拼接错误");
        }
        return buffer.toString();
    }

    /**
     * @Description
     * @Param array
     * @Param separator
     * @Return java.lang.String
     * @Author Martin
     * @Date 2020/8/31 14:07
     */
    public static String join(final Object[] objects, final String separator) {
        if (objects.length == 0) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        for (Object object : objects) {
            buffer.append(separator).append(object);
        }
        return buffer.substring(2).toString();
    }

    /**
     * Object转String
     * @param obj
     * @return String
     * @author Martin
     * @date 2019/10/10
     */
    public static String toString(Object obj) {
        return obj == null ? null : obj.toString();
    }

    /**
     * 下划线转驼峰
     * @param str
     * @return String
     * @author zhongmin
     * @date 201/09/05
     */
    public static String lineToHump(String str) {
        String paln = "_(\\w)" ;
        Pattern linePattern = Pattern.compile(paln);
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * @Description 批量下划线转驼峰
     * @Param list
     * @Return java.util.List<java.lang.String>
     * @Author Martin
     * @Date 2020/8/26 16:31
     */
    public static List<String> lineToHumpBatch(List<String> list) {
        if (list.isEmpty()) return list;
        List<String> humpList = new ArrayList<>();
        list.forEach(line -> humpList.add(StringUtils.lineToHump(line)));
        return humpList;
    }

    /**
     * 首字母大写
     * @param str
     * @return String
     * @author zhongmin
     * @date 201/09/05
     */
    public static String FirstLetterToUpperCase(String str) {
        String firstLetter = str.substring(0, 1).toUpperCase();
        String otherLetter = str.substring(1, str.length());
        return StringUtils.append(firstLetter, otherLetter);
    }

    /**
     * @Description 首字母小写
     * @Param str
     * @Return java.lang.String
     * @Author Martin
     * @Date 2020/8/27 14:30
     */
    public static String FirstLetterToLowerCase(String str) {
        String firstLetter = str.substring(0, 1).toLowerCase();
        String otherLetter = str.substring(1, str.length());
        return StringUtils.append(firstLetter, otherLetter);
    }

    /**
     * 驼峰转下划线
     * @param str
     * @return String
     * @author zhongmin
     * @date 201/09/05
     */
    public static String humpToLine(String str) {
        Pattern humpPattern = Pattern.compile("[A-Z]");
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, "_"+matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 比较字符串是否相等
     * @param a
     * @param b
     * @return boolean
     */
    public static boolean equals(CharSequence a, CharSequence b) {
        if (a == b) return true;
        if (a == null || b == null) return false;
        if (a.length() != b.length()) return false;

        if (a instanceof String && b instanceof String) {
            return a.equals(b);
        }

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    /**
     * @Description 判断是否为金额格式，支持两位小数
     * @Param str
     * @Return boolean
     * @Author WangYan
     * @Date 2020/9/13 14:42
     */
    public static boolean isNumber(String str) {
        Pattern pattern= Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$");
        Matcher match=pattern.matcher(str);
        return match.matches();
    }

    /**
     * @param idCard 身份证号
     * @Description 身份证验证
     * @Author guolf
     * @Date 2020/10/19 09:46
     */
    public static boolean isIdCardNo(String idCard){
        String reg ="\\d{17}[\\d|x|X]|\\d{15}";
        return Pattern.matches(reg,idCard);
    }
}
