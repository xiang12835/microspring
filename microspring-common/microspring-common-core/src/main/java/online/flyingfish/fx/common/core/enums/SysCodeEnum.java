package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统代码信息
 * @date 2021/9/18
 * @Notice 无
 */
@Getter
@AllArgsConstructor
public enum SysCodeEnum implements BaseEnum {
    ESB("0", "ESB", "企业数据总线"),
    JD_MANAGE("1", "JD_MANAGE", "军油卡管理平台"),
    DUMMY("2", "dummy", "挡板"),
    DC_DIRECT("3", "DC_DIRECT", "数币核心直连"),
    CPDC("4", "CPDC", "中石化"),
    CNPC("5", "CNPC", "中石油"),
    ORG("99700050000", "ORG", "机构管理系统"),
    NGISS("99711230000", "NGISS", "新一代国际结算系统"),
    USER("99700060000", "USER", "柜员管理系统"),
    EDB("99700070000", "EDB", "企业数据总线"),
    SMS("99100100000", "SMS", "95580短信平台"),
    ITSP("99710640000", "ITSP", "统一柜面"),
    TCIP("99700040000", "TCIP", "传统渠道"),
    OSSIP("99711800000", "OSSIP", "军队油料保障结算平台"),
    DCEP("99711310000", "DCEP", "核心系统"),

    UNKNOWN_SYSTEM("99999", "UNKNOWN_SYSTEM", "未知系统");
    /**
     * 系统编号
     */
    private final String code;
    /**
     * 系统简称
     */
    private final String name;
    /**
     * 系统描述
     */
    private String remark;

    @Override
    public String getMessage() {
        return remark;
    }

    /**
     * 根据code获取系统枚举
     * @date 2021/10/28
     * @param code
     * @Notice 无
     */
    public static SysCodeEnum getSysCodeEnumFromCode(String code) {
        for (SysCodeEnum sysCodeEnum : SysCodeEnum.values()) {
            if (sysCodeEnum.getCode().equals(code)) {
                return sysCodeEnum;
            }
        }
        return UNKNOWN_SYSTEM;
    }
}
