package cn.gatesma.desirefu.constants;

public enum ApiReturnCode {
    AUTHENTICATION_FAILED(-1),                  // 权限错误
    OK(0),                                      // OK
    ACCOUNT_MISSING_ERROR(100),                 // 未指定账号信息
    RESOURCE_NOT_FOUND(101),                    // 访问的资源不存在
    PB_PARSE_ERROR(102),                        // PB结构数据解析错误
    PB_WRITE_ERROR(103),                        // PB结构数据写入错误
    DATA_FORMAT_ERROR(104),                     // 数据类型错误
    HEADER_ACCEPT_MISSING(105),                 // Http请求中未指定Accept头域
    INVALID_ARGUMENT(106),                      // 非法的参数
    SIMULTANEOUS_UPDATE(107),                   // 并发更新错误
    SERIES_OPERATION_PARTLY_FAILED(108),        // 事务中部分操作失败
    SERIES_OPERATION_TOTALLY_FAILED(109),       // 事务中全部操作失败
    INVALID_CERTIFICATION_CODE(110),            // 非法的资质编码
    CERTIFICATION_HAS_EXISTED(111),             // 资质已存在
    CERTIFICATION_LIST_EMPTY(119),              // 资质列表为空
    MODIFY_APPROVED_CERTIFICATION(120),         // 修改已审核的资质信息
    UNIQUENESS_CHECK_FAILED(121),               // 唯一性校验失败

    UPLOAD_FILE_PARSE_ERROR(130),               // 上传文件解析失败
    UPLOAD_SIGNATURE_CHECK_FAILED(131),         // 上传文件签名验证失败
    UPLOAD_FILE_EMPTY_ERROR(132),               // 上传文件为空
    UPLOAD_FILE_EXISTS(133),                    // 上传文件已存在
    UPLOAD_FILE_EXCEEDS_LIMIT(134),             // 上传文件超过大小限制
    UPLOAD_FILE_TYPE_INCONSISTENT(135),         // 上传文件内容与指定类型不一致
    UPLOAD_FILE_TO_CDN_ERROR(136),              // 上传文件至CDN失败

    LOGIN_NO_SUCH_ACCOUNT_ERROR(140),           // 查无此账号
    LOGIN_NO_OPERATE_AUTH_ERROR(141),           // 当前登录者无操作权限
    LOGIN_NOT_SUITABLE_ACCOUNT_TYPE_ERROR(142), // 此账号类型无法适用于所要登录的业务系统
    LOGIN_NOT_SUITABLE_ROLE_ERROR(143),         // 此角色无法适用于所要登录的业务系统
    LOGIN_NOT_SUPPORTED_ERROR(144),             // 不支持当前账号登录
    LOGIN_NO_CONFIGURES_FOUND_ERROR(145),       // 当前serviceTag没有配置数据异常
    LOGIN_NO_SUCH_USER_ERROR(146),              // 查无此用户
    LOGIN_NOT_SUITABLE_ACCOUNT_STATUS_ERROR(147),// 此账号状态无法适用于所要登录的业务系统

    ACCOUNT_HAS_EXISTED(149),                   // 账号已存在
    USER_HAS_EXISTED(150),                      // 用户已存在
    CHECK_BINDING_RESTRICTION_FAILED(151),      // 违反用户、账号、角色绑定规则
    ACCOUNT_NOT_EXISTED(152),                   // 账号不存在
    NONE_ADVERTISER_AGENCY_RELATION(153),       // 代理商和子客关联关系不存在
    USER_NOT_EXISTED(154),                      // 用户不存在
    USER_NOT_ALLOWED_DELETE(155),               // 用户不允许删除

    ADD_FUND_ACCOUNT_FAILURE(160),              // 添加资金账户失败
    GET_FUND_ACCOUNT_FAILURE(161),              // 获取资金账户失败

    NOT_SUPPORT_SEARCH_NO_ACCOUNT_TYPE(170),    // 待查询账户不支持不传accountType的方式查询

    CUSTOMER_CHANNEL_HAS_EXISTED(181),          //客户已存在
    CUSTOMER_NOT_EXISTED_ERROR(182),
    CUSTOMER_SALES_CHANNEL_NOT_EXISTED(183),

    MDM_NOT_FOUND(184),                         // MDM ID不存在

    INDUSTRY_ADDITIONAL_LIST_EMPTY(200),        // 附加行业列表为空
    INDUSTRY_CERTIFICATION_LIST_EMPTY(201),     // 行业资质列表为空
    CERTIFICATION_HAS_APPROVED(202),            // 资质已审核通过

    HTTP_REQUEST_MAPPING_ERROR(400),            // 请求中的参数类型与API定义不一致

    INNER_ERROR(500),                           // 系统内部错误
    GET_DI_GENERATED_ID_ERROR(501),             // 获取DI自增主键错误
    EXT_LENGTH_EXCEED(502),                     // EXT字段超长

    //外部系统接口错误
    GREENSPAN_API_ERROR(600),                   //greenspan数据接口错误

    FINANCIAL_TAG_ID_ADD_DENIED(701),           // 不允许添加财务标签
    FINANCIAL_TAG_ID_UPDATE_DENIED(702),        // 不允许更新财务标签

    CMLB_INIT_ERROR(800),                       // cmlb初始化异常
    OIDB_SOCKET_REQUEST_ERROR(801),             // OIDB socket请求异常
    OIDB_API_0X70F_ERROR(802),                  // OIDB 0x70f调用异常
    OIDB_API_0x70F_NO_VALID_QQ(803),            // OIDB 0x70f调用提示QQ号非有效

    GET_WX_OPENID_ERROR(850),                   // 获取微信openID错误
    GET_WX_OPENID_WXID_INVALID_ERROR(851),      // 获取微信openID微信账号无效

    // 集团
    GROUP_HAS_ACCOUNT_RELATION(901),            // 集团有关联账号，不能删除

    BALANCE_NOT_EMPTY(1000),                    // 余额不为0

    // 角色
    ROLE_OPERATION_PROHIBITED(1001),            // 没有当前角色操作权限
    USER_HAS_ALREADY_BINDING_TO_ACCOUNT(1002),  // 用户已经和账号绑定
    ACCOUNT_ALREADY_HAS_ROLE_USER(1003),        // 当前角色只能设置一个协作者
    ROLE_CAN_NOT_BE_MODIFIED(1004),             // 当前角色不能被修改
    SELF_OPERATOR_OVER_ADVERTISER_LIMIT(1005),  // 自理管理员管理子客超过上限
    ACCOUNT_ROLE_NOT_EXISTED(1006),             // 当前账号角色信息不存在

    // 幂等开户
    ADD_ACCOUNT_ERROR(1101),                    // 账号创建失败，请线下修复
    INVALID_SIGNATURE_ERROR(1102),              // 账号创建参数签名不一致
    DEPRECATED_VERSION_NO(1103),                // 账号更新版本号低于当前版本号，更新失败

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
    ENCAPSULATION_ERROR(12017)                  // 封装其他异常到CustomerApiException
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

