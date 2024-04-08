package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 业务代码枚举
 * @date 2020-03-05
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum ResultCodeEnum implements BaseEnum {

    /**
     * 通用业务处理结果代码枚举值定义
     */
    SUCCESS("000", "操作成功"),
    FAILURE("000001", "系统异常"),
    SYSTEM_ERROR("000002", "内部错误: 交易流水号【{0}】,服务名【{1}】,错误信息【{2}】,链路跟踪号【{3}】"),
    DB_ERROR("000003", "数据库异常: 交易流水号【{0}】,服务名【{1}】"),
    PARAM_ERROR("000004", "参数校验错误异常：{0}"),
    PARAM_VALIDATE_ERROR("000005", "参数校验错误异常:{0}"),
    RECORD_NOT_EXIST("000006", "记录不存在"),
    RESUBMIT("000007", "重复提交"),
    MISS_TYPE("000008", "类型缺失【{0}】"),
    HTTP_REQUEST_ERR("000009", "接口请求失败"),
    VERIFY_MESSAGE_FAIL("000010", "验证短信验证码失败,请重试"),
    VERIFY_MESSAGE_ERROR("000011", "短信验证码错误,请重新输入"),
    SEND_MESSAGE_FAIL("000012", "获取短信验证码失败,请重试"),
    USER_TOKEN_INVALID("000013", "用户不存在或者认证过期"),
    CIRCUITBREAKER_ERROR("000014", "触发熔断，系统繁忙"),
    NOT_ACCEPTABLE("000015", "不可访问"),
    DECRYPT_ERROR("000016", "解密异常"),
    ENCRYPT_ERROR("000017", "加密异常"),
    RATELIMITER_ERROR("000018", "请求被限流"),
    MESSAGE_CODE_NOT_EXPIRE("000019", "请勿在10分钟内重复获取验证码"),
    INST_CODE_NOT_EXIST("000020", "缺少机构编号"),

    /**
     * 油卡类处理结果代码枚举值定义
     */
    CARD_NUM_NULL("010001", "制卡配送接收失败，制卡数量不能为0或空"),
    CARD_TYPE_NOT_EXIST("010002", "制卡配送信息接收失败，该类卡在卡库中不存在"),
    CARD_NUM_NEG("010003", "制卡配送信息接收失败，制卡数量不能为负数"),
    NON_ACTIVE("010004", "卡片处于非激活状态，无法执行查询操作"),
    CARD_STATUS_EXCEPTION("010005", "油卡状态异常"),
    CARD_NO_NOT_EXIST("010006", "卡号不存在"),
    CARDNO_NOT_MATCH("010007", "卡号不匹配"),
    NON_EMPTY_CARDNO("010008", "卡号不能为空，请输入卡号"),
    MSG_NOT_REGULAR("010009", "卡片处于非正常状态，不能换卡"),
    MSG_CARD_ACTIVE("010010", "新卡已激活，不能换卡"),
    MSG_CARD_INDEX_ERROR("010011", "输入卡号与唯一标识不匹配"),
    ACCOUNT_ID_ERROR("010012", "油卡唯一标识异常"),
    PHONE_PROBLEM("010013", "手机号校验失败"),
    PHONE_NOT_EXIST("010014", "该手机号不存在"),
    MSG_MOBILE_NO_INDEX_ERROR("010015", "输入手机号与卡号不匹配"),
    CARD_PHONE_BIND("010016", "卡片已经绑定手机号"),
    FUEL_TYPE_ERROR("010017", "油品类型非指定油品类型"),
    FUEL_CONTAINER_ERROR("010018", "邮箱容量为非正数"),
    FUEL_EXPIRE_TIME_ERROR("010019", "卡片有效期格式异常，非yyyyMMdd"),
    FUEL_CARD_NO_ALREADY_EXIST("010020", "油卡卡号已存在"),
    FUEL_CARD_TYPE_ERROR("010021", "油卡类型错误"),
    FUEL_CARD_NUMBER_ERROR("010022", "油卡数量与实际不一致"),
    CAR_NO_LENGTH_ERROR("010023", "车牌号位数错误"),
    MOBILE_NOT_IN_WL("010024", "手机号不在白名单中"),
    LOGIN_PWD_WRONG("010025", "登录密码错误"),
    PAY_PWD_WRONG("010026", "支付密码错误"),
    VERIFY_CODE_WRONG("010027", "短信验证码错误"),
    LOGIN_PWD_RIGHT("010028", "登录密码输入正确"),
    PAY_PWD_RIGHT("010029", "支付密码输入正确"),
    PWD_UPDATE_SUCCESS("010030", "密码修改成功"),
    PWD_UPDATE_FAILURE("010031", "密码修改失败"),
    CHECK_CODE_OR_PWD_NOT_EMPTY("010032", "请输入短信验证码或原密码"),
    FUEL_CARD_NO_REPEAT("010033", "油卡卡号存在重复"),


    /**
     * 指标类处理结果代码枚举值定义
     */
    INDEX_NOT_ENOUGH("020001", "指标额度不足"),
    CARD_NOT_EXIST("020002", "卡号不存在"),
    CARD_STATUS_ERROR("020003", "油卡状态异常"),
    LOCK_RECORD_NOT_EXIST("020004", "未查询到相应的锁定记录"),
    LOCATION_NOT_SAME("020005", "加油地点不一致"),
    QUOTA_GT_CONTAINER("020006", "预锁定指标大于油箱容量"),
    QUOTA_LOCK_FAIL("020007", "指标锁定失败"),
    QUOTA_UNLOCK_FAIL("020008", "取消锁定失败"),
    LOCK_FLAG_ERROR("020009", "锁定标识错误"),
    ADJUST_YEAR_NOT_EXIST("020010", "指标调整年份不存在"),
    CARD_NO_NOT_MATCH("020011", "卡号与锁定记录不一致"),
    ADJUST_INSTRUCT_IS_EMPTY("020012", "指标调整指令为空"),
    ADJUST_FAIL("020013", "指标调整失败"),

    /**
     * 支付类处理结果代码枚举值定义
     */
    ENTERPRISE_WALLET_NOT_EXIST("030001", "油企钱包不存在"),
    ENTERPRISE_WALLET_NOT_MATCH("030002", "油企钱包名称或所属运营机构不匹配"),
    ENTERPRISE_WALLET_TYPE_ERROR("030003", "油企钱包非对公钱包"),
    ENTERPRISE_WALLET_STATUS_ERROR("030004", "油企钱包状态异常"),
    ENTERPRISE_WALLET_PAYMENT_STATUS_ERROR("030005", "油企钱包收付状态异常"),
    ENTERPRISE_WALLET_BALANCE_LIMIT_ERROR("030006", "油企钱包余额超过上限"),
    ENTERPRISE_WALLET_SINGLE_TRANS_AMOUNT_LIMIT_ERROR("030007", "油企钱包单笔交易超过上限"),
    ENTERPRISE_WALLET_DAILY_TRANS_AMOUNT_LIMIT_ERROR("030008", "油企钱包当日累计交易超过上限"),
    ENTERPRISE_WALLET_ANNUALLY_TRANS_AMOUNT_LIMIT_ERROR("030009", "油企钱包当年累计交易超过上限"),
    ENTERPRISE_WALLET_QUERY_ERROR("030010", "油企钱包查询异常"),
    MILITARY_WALLET_TYPE_ERROR("030011", "军方钱包非对公钱包"),
    MILITARY_WALLET_TRANSFER_PROCESSING("030012", "钱包转账交易处理中"),
    MILITARY_WALLET_REQUEST_ERROR("030013", "钱包转账交易请求参数错误："),
    MILITARY_WALLET_INFO_ERROR("030014", "钱包信息异常："),
    MILITARY_WALLET_PROTOCOL_ERROR("030015", "钱包签约信息异常："),
    MILITARY_WALLET_TRANSFER_ERROR("030016", "钱包转账交易异常："),
    TRANSFER_PARAM_ERROR("030017", "结算批次总比数或总金额不匹配"),
    OPR_ERROR("030018", "操作类型错误"),
    SETTLED_ORDER_UNDONE("030019", "结算任务存在未处理完成订单"),
    SETTLE_TASK_REPEATED("030020", "结算任务流水号重复"),
    SETTLE_ORDER_REPEATED("030021", "结算任务下订单流水号重复"),
    SETTLE_ORDER_NOT_FOUND("030022", "未找到结算订单"),
    OPEN_CHANNEL_ERROR("030023", "开通渠道服务服务响应异常"),
    SETTLE_ORDER_STATUS_NOT_NEED_RETRY("030024", "结算订单非异常状态不能补发"),
    SETTLE_ORDER_NO_PAY_RECORD_TO_RETRY("030025", "结算订单没有支付记录不能补发"),
    SETTLE_TASK_NOT_MATCH("030026", "结算任务总笔数或总金额不匹配"),
    SETTLE_ORDER_RETRY_CHECK_ERROR("030027", "结算订单重试校验失败："),
    WALLET_INFO_ERROR("030028", "钱包信息有误"),
    WALLET_QUERY_ERROR("030029", "钱包查询未响应"),
    PASSWORD_RESET_ERROR("030030", "密码重置有误"),
    MOBILE_WHITE_LIST_EMPTY("030031", "手机号白名单为空"),
    PAYER_WALLET_INFO_NOT_EXIST("030032", "付款方钱包ID不存在"),
    SETTLE_ORDER_LIST_OVER_MAX_NUMBER("030033", "单笔结算任务下结算订单数不超过【%s】笔"),
    QUERY_SIGN_NO_ERROR("030034", "查询签约协议号服务响应异常"),
    RETURN_SIGNNO_IS_NULL("030035", "数币返回签约协议号为空"),
    TASK_SETTLE_TIME_INVALID("030036", "结算任务【%s】的结算时间【%s】格式异常，格式需为yyyyMMddHHmmss"),

    /**
     * 管理端处理结果代码枚举值定义
     */
    TELLER_EXIST("040001", "柜员已存在"),
    TELLER_SYS_CANCEL("040002", "柜员系统已注销"),
    UPDATE_FAIL("040003", "更新失败"),
    CREATE_FAIL("040004", "创建失败"),
    DELETE_FAIL("040005", "删除失败"),
    ROLE_EXIST("040006", "角色编号已存在"),
    AUDITOR_EXIST("040007", "审计员角色不能同时担任其他角色"),


    /**
     * 渠道错误码
     */
    ESB_FAILURE("02200001", "渠道调用异常"),
    ESB_TELLER_PWD_UNLOCKED("02200016", "该柜员密码未锁定"),
    ESB_TELLER_NOT_EXIST("02200046", "该柜员不存在"),
    ESB_TELLER_PWD_ERROR("02200011", "密码输入错误"),
    ESB_TELLER_PWD_ERROR_LOCKED("02200078", "密码输入错误，该柜员已被锁定"),
    ESB_TELLER_PWD_LOCKED("02200055", "该柜员密码已锁定"),
    ESB_TELLER_NOT_ACCEPTABLE("100014", "无权操作目标柜员所在机构"),
    ESB_TELLER_ALREADY_SIGN_IN("02200006", "柜员已签到，不可重复签到"),
    ESB_TELLER_NOT_SAME("02200113", "操作柜员与被操作柜员不能是同一人"),
    ESB_TELLER_NOT_SIGN_IN("02200008", "被强制签退柜员未签到"),
    ESB_TELLER_HAS_SIGN("02200083", "该柜员是签到状态不可被重置密码或者信息修改"),
    ESB_PERSON_NOT_EXIST("100023", "柜员系统查无此人"),
    ESB_SERVE_NAME_NOT_FIT("09200009", "调用服务名与渠道提供的该交易服务名不一致"),
    ESB_OPR_TELLER_NOT_EXIST("02200026", "操作柜员不存在"),
    ESB_OPR_TELLER_NOT_ALLOWED("02200024", "操作柜员无权限做此交易"),
    ESB_OPR_TELLER_NOT_SIGN_IN("02200082", "柜员没有签到"),
    /**
     * 数币核心响应码枚举值定义
     */
    DUPLICATE_SIGN("R040", "重复签约"),

    /**
     * 领油/送油处理结果代码枚举值定义
     */
    OIL_APPOINTMENT_ORDER_EXIST("050001", "领油/送油预约单已存在"),
    OIL_TOTAL_PRICE_ERROR("050002", "总价不正确"),
    OIL_APPOINTMENT_ORDER_NOT_EXIST("050003", "领油/送油预约单不存在"),
    OIL_APPOINTMENT_ORDER_STATUS_ERROR("050004", "领油/送油预约单状态异常"),
    OIL_APPOINTMENT_ORDER_BEFORE_NOW("050005", "预约日期在当前日期（含）之前，无法取消预约"),

    /**
     * 对账文件
     */
    RECONCILIATION_DATA_NOT_EXIST("060001", "对账数据不存在"),
    RECONCILIATION_GENERATE_ERROR("060002", "生成对账文件失败"),
    PUBLIC_KEY_NOT_EXIST("060003", "公钥不存在"),
    UPLOAD_ERROR("060004", "对账文件上传失败"),
    FILE_NOT_EXIST("060005", "对账文件不存在"),

    /**
     * kafka
     */
    KAFKA_CONSUMER_FAIL("070001", "kafka消费异常"),


    /**
     * 权益
     *
     */
    COUPON_COUNT_FAIL("090001","优惠券库存不足"),
    COUPON_START_DATE_FAIL("090002","未在优惠券领取时间"),
    COUPON_END_DATE_FAIL("090003","已过优惠券结束时间"),
    USER_OBTAIN_FAIL("090004","用户领取已达上限"),
    ;
    /**
     * 响应code
     */
    private final String code;
    /**
     * 响应信息描述
     */
    private final String message;

    /**
     * 根据code获取返回枚举类型
     * @param code
     * @date 2021/11/15
     * @Notice 无
     */
    public static ResultCodeEnum obtainValueByCode(String code) {
        for (ResultCodeEnum stateEnum : ResultCodeEnum.values()) {
            if (code.equals(stateEnum.getCode())) {
                return stateEnum;
            }
        }
        return FAILURE;
    }
}