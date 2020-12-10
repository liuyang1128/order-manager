package com.orders.constant;

/**
 * @Description: 错误码
 * @Author liuyang
 * @Date 2020/6/9 19:56
 */
public interface ErrorCode {

    /*
     * 400001 - 400100  系统、远程请求、系统调度异常
     * 400101 - 400200  入参对象，包括但是不限于集合、数组、属性、值、取值范围等
     * 400201 - 400300  Token、权限
     * 400301 - 400400  待定
     * 400401 - 400500  待定
     * 400501 - 400600  待定
     * 400601 - 400700  待定
     * 400701 - 400800  待定
     * 400801 - 400900  待定
     * 400901 - 401000  待定
     */

    /**
     * 接口调用成功
     */
    public static final String SUCCESS = "0";

    /**
     * 系统异常
     */
    public static final String SYSTEM_NOT_HEALTHY = "400001";

    /**
     * 服务异常
     */
    public static final String SERVICE_ERROR = "400002";

    /**
     * 系统内部异常
     */
    public static final String SYSTEM_ERROR = "400003";

    /**
     * 业务异常
     */
    public static final String BUSINESS_ERROR = "400004";

    /**
     * 可重试异常
     */
    public static final String RETRY_ERROR = "400005";

    /**
     * 远程请求错误
     */
    public static final String REMOTE_REQUEST_ERROR = "400006";

    /**
     * 执行方法错误
     */
    public static final String EXCUTE_METHOD_ERROR = "400007";

    /**
     * MQ发送消息错误
     */
    public static final String MQ_SEND_ERROR = "400008";

    /**
     * 拦截器处理异常
     */
    public static final String AUTHEN_HANDLE_ERROR = "400009";

    /**
     * 请求地址错误
     */
    public static final String REQUEST_ADDRESS_ERROR = "400010";

    /**
     * 请求执行错误
     */
    public static final String REQUEST_EXCUTE_ERROR = "400011";

    /**
     * 发送短信错误
     */
    public static final String SEND_ALIYUN_SMS_ERROR = "400013";

    /**
     * 找不到文件
     */
    public static final String NOT_FOUND_FILE = "400014";

    /**
     * 写入文件错误
     */
    public static final String WRITE_FILE_ERROR = "400015";

    /**
     * IO异常
     */
    public static final String IO_ERROR = "400016";

    /**
     * IO流关闭异常
     */
    public static final String IO_CLOSE_ERROR = "400017";

    /**
     * 请求超时
     */
    public static final String TIMEOUT_ERROR = "400018";

    /**
     * 平台编号不存在
     */
    public static final String PLATFORMNO_ERROR = "400019";

    /**
     * 签名验证失败
     */
    public static final String VERIFY_ERROR = "400020";

    /**
     * 无此业务接口
     */
    public static final String WITHOUTBUSINESS_ERROR = "400021";

    /**
     * 无此业务接口
     */
    public static final String EXTRACT_XML_ERROR = "400022";

    /**
     * 无此业务接口
     */
    public static final String PARSE_XML_ERROR = "400023";

    /**
     * 验签错误
     */
    public static final String PARES_SIGN_ERROR = "400024";

    /** 400101 - 400200  入参对象，包括但是不限于集合、数组、属性、值、取值范围等 */

    /**
     * 主键为空
     */
    public static final String PRIMARY_IS_NULL = "400101";

    /**
     * 参数为空
     */
    public static final String PARAM_IS_NULL = "400102";

    /**
     * 参数错误
     */
    public static final String PARAM_ERROR = "400103";

    /**
     * 数据重复
     */
    public static final String DATA_EXISTS = "400104";

    /**
     * 未查到有效的数据
     */
    public static final String DATA_INVALID = "400105";

    /** 400201 - 400300 Token、权限 */

    /**
     * token不能为空
     */
    public static final String TOKEN_IS_NULL = "400201";

    /**
     * 非法token
     */
    public static final String ILLEGALITY_TOKEN = "400202";

    /**
     * 失效token token过期
     */
    public static final String LOSE_EFFICACY_TOKEN = "400203";

    /**
     * 用户不存在
     */
    public static final String USER_NOT_EXIST = "400204";

    /**
     * 密码不正确
     */
    public static final String PASSWORD_ERROR = "400205";

    /**
     * 非法权限
     */
    public static final String ILLEGALITY_AUTH = "400206";
}