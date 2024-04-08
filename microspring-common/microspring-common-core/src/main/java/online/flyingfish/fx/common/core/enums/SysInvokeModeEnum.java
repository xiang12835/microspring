package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 接口调用方式
 * @date 2021/9/18
 * @Notice 无
 */
@Getter
@AllArgsConstructor
public enum SysInvokeModeEnum implements BaseEnum {
    DUMMY(SysCodeEnum.DUMMY.getCode(), SysCodeEnum.DUMMY.getRemark(), AdapterTypeEnum.DUMMY.getType()),
    SMS(SysCodeEnum.SMS.getCode(), SysCodeEnum.SMS.getRemark(), AdapterTypeEnum.ESB.getType()),
    TCIP(SysCodeEnum.TCIP.getCode(), SysCodeEnum.TCIP.getRemark(), AdapterTypeEnum.ESB.getType()),
    JD_MANAGE(SysCodeEnum.JD_MANAGE.getCode(), SysCodeEnum.JD_MANAGE.getRemark(), AdapterTypeEnum.RESTFUL.getType()),
    DC_DIRECT(SysCodeEnum.DC_DIRECT.getCode(), SysCodeEnum.DC_DIRECT.getRemark(), AdapterTypeEnum.RESTFUL.getType()),
    ;

    /**
     * 系统编号
     */
    private final String code;
    /**
     * 系统简称
     */
    private final String name;
    /**
     * 渠道平台调用方式
     */
    private String invokeMode;

    @Override
    public String getMessage() {
        return "";
    }

    /**
     * 根据适配器类型获取适配器Bean Name
     * @param type 适配器类型
     * @return
     */
    public static String getInvokeModeByType(String type) {
        for (SysInvokeModeEnum enums : SysInvokeModeEnum.values()) {
            if (enums.getCode().equalsIgnoreCase(type)) {
                return enums.getInvokeMode();
            }
        }
        return AdapterTypeEnum.RESTFUL.getType();
    }
}
