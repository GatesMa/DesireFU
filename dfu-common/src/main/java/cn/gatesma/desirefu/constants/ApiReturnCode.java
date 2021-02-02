package cn.gatesma.desirefu.constants;

public enum ApiReturnCode {
    AUTHENTICATION_FAILED(-1),                  // 权限错误
    OK(0),                                      // OK
    ACCOUNT_MISSING_ERROR(100),                 // 未指定账号信息
    RESOURCE_NOT_FOUND(101),                    // 访问的资源不存在
    DATA_FORMAT_ERROR(102),                     // 数据类型错误
    HEADER_ACCEPT_MISSING(103),                 // Http请求中未指定Accept头域
    INVALID_ARGUMENT(104),                      // 非法的参数
    SIMULTANEOUS_UPDATE(105),                   // 并发更新错误
    SERIES_OPERATION_PARTLY_FAILED(106),        // 事务中部分操作失败
    SERIES_OPERATION_TOTALLY_FAILED(107),       // 事务中全部操作失败
    UNIQUENESS_CHECK_FAILED(108),               // 唯一性校验失败

    UPLOAD_FILE_PARSE_ERROR(130),               // 上传文件解析失败
    UPLOAD_SIGNATURE_CHECK_FAILED(131),         // 上传文件签名验证失败
    UPLOAD_FILE_EMPTY_ERROR(132),               // 上传文件为空
    UPLOAD_FILE_EXISTS(133),                    // 上传文件已存在
    UPLOAD_FILE_EXCEEDS_LIMIT(134),             // 上传文件超过大小限制
    UPLOAD_FILE_TYPE_INCONSISTENT(135),         // 上传文件内容与指定类型不一致

    ACCOUNT_HAS_EXISTED(150),                   // 账号已存在
    USER_HAS_EXISTED(151),                      // 用户已存在
    CHECK_BINDING_RESTRICTION_FAILED(152),      // 违反用户、账号、角色绑定规则
    ACCOUNT_NOT_EXISTED(153),                   // 账号不存在
    USER_NOT_EXISTED(154),                      // 用户不存在

    HTTP_REQUEST_MAPPING_ERROR(400),            // 请求中的参数类型与API定义不一致

    INNER_ERROR(500),                           // 系统内部错误


    EXTERNAL_INTERFACE_ERROR(600),              // 请求外部接口失败

    // 通用错误
    UNKNOWN_ERROR(12000),                       // 未知错误
    PARAMETER_EMPTY(12001),                     // 参数为空
    ILLEGAL_PARAM(12002),                       // 非法参数
    PAGE_SIZE_EXCEED_LIMIT(12003),              // 设置的分页条数超过最大限制
    DATA_INCONSISTENCY_BETWEEN_NEW_OLD(12004),  // 新表与旧表数据不一致
    PAGE_OUT_OF_BOUNDS(12005),                  // 分页超过数据边界
    RESOURCE_HAS_DELETED(12006),                // 资源已经被删除
    DEPRECATED_FUNCTION(12007),                 // 功能废弃
    RATE_LIMIT(12008),                          // 接口限流
    PROCESS_WAS_INTERRUPTED(12009),             // 操作被中断
    DOWNGRADE_ERROR(12010),                     // 降級错误
    PROCESS_TIMEOUT_ERROR(12011),               // 操作超时
    BREAK_WHITELIST_RESTRICTION(12013),         // 违反白名单约束
    BREAK_BLACKLIST_RESTRICTION(12014),         // 违反黑名单约束
    NOT_SUPPORT_OPERATION(12015),               // 不支持的操作
    FAST_FAIL(12016),                           // 快速失败
    ENCAPSULATION_ERROR(12017),                 // 封装其他异常到CustomerApiException
    LOGIC_ERROR(12018)
    ;

    public static final String INNER_ERROR_MSG = "系统错误，请稍后再试";
    private int retCode;

    ApiReturnCode(int retCode) {
        this.retCode = retCode;
    }

    public static ApiReturnCode parseCode(int retCode) {
        for (ApiReturnCode apiRetCode : ApiReturnCode
                .values()) {
            if (apiRetCode.retCode == retCode) {
                return apiRetCode;
            }
        }
        return null;
    }

    public int code() {
        return this.retCode;
    }
}

