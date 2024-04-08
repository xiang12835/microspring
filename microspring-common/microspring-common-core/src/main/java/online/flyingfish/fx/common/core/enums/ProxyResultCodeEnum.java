package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 接出服务异常代码枚举
 * @date 2020-03-05
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum ProxyResultCodeEnum implements BaseEnum {
    /**
     * 接出服务异常
     */
    SUCCESS("000000", "接口调用成功"),
    ESB_OUT_ERROR("080101", "ESB调用异常: {0}"),
    ESB_RESP_EMPTY_ERROR("080102", "ESB响应体为空"),
    ESB_COMMON_MSG_CONVERT_ERROR("080103", "公共报文域转换Map失败"),
    ESB_BIZ_MSG_CONVERT_ERROR("080104", "业务报文域转换Map失败"),
    RESTFUL_RESP_EMPTY_ERROR("080105", "Restful请求响应体为空"),
    GEN_MAC_FAILED("080106", "生成MAC失败"),
    RESP_MSG_FORMAT_ERROR("080107", "接口响应信息缺失"),
    ESB_TIMEOUT_ERROR("080108", "ESB调用异常: 接口调用超时"),
    ESB_INTF_CONFIG_NOT_EXIST_ERROR("080201", "接口[{0}]的配置信息缺失"),
    ESB_SYS_CONFIG_NOT_EXIST_ERROR("080202", "系统[{0}]配置信息缺失"),
    ESB_INTF_CONNECT_METHOD_NOT_EXIST("080203", "无法获取接口[{0}]的接出方式"),

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
     * 判断指定的异常代码是否在当前枚举属性里
     * @param code 枚举code
     * @return 是否包含
     */
    public static boolean isInclude(String code) {
        for (ProxyResultCodeEnum partyEnum : ProxyResultCodeEnum.values()) {
            if (partyEnum.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据key获取去value
     * @param code 枚举代码
     * @return 枚举响应的说明
     */
    public static String getValueByCode(String code) {
        for (ProxyResultCodeEnum stateEnum : ProxyResultCodeEnum.values()) {
            if (code.equals(stateEnum.getCode())) {
                return stateEnum.getMessage();
            }
        }
        return null;
    }
}