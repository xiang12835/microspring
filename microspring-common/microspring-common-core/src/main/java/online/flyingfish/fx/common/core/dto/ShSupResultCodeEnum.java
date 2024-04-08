package online.flyingfish.fx.common.core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 业务代码枚举
 *
 * @date 2020-03-05
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum ShSupResultCodeEnum implements IResultCode {

    SYS_FAIL("001", "系统异常"),
    MSG_FAIL("002", "报文格式异常"),
    DATA_FAIL("003", "数据格式异常"),
    BUS_DATA_FAIL("004", "业务数据异常"),
    BUS_DATA_NULL("005","业务数据为空"),

    /**
     * 通用业务处理结果代码枚举值定义
     */
    SUCCESS("000", "操作成功"),
    SUCCESS2("WKF033", "操作成功"),
    CANCEL("999997", "交易撤销异常"),
    RESUBMIT("999998", "重复提交"),
    FAILURE("999999", "业务异常"),
    FAILURE2("000999","业务异常"),
    WAITING("WAIT01","业务等待中。。。");
    /**
     * 响应code
     */
    private final String code;
    /**
     * 响应信息描述
     */
    private final String message;
}
