/**
 * All rights reserved.
 * Created on 2021-09-06
 */
package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 柜员状态码
 * @date 2021-09-06
 * @Version V1.0
 * @Notice
 */
@Getter
@AllArgsConstructor
public enum TellerStatusCodeEnum {
    /**
     * 启用
     */
    NORMAL("1", "启用"),
    /**
     * 停用
     */
    BLOCK("2", "停用"),
    /**
     * 柜员系统停用
     */
    SYN_BLOCK("3", "柜员系统停用");

    /**
     * 柜员状态代码
     */
    private final String tellerStatusCode;

    /**
     * 柜员状态名称
     */
    private final String tellerStatusName;
}
