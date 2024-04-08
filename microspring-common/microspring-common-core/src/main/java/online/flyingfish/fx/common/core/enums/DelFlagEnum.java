/**
 * All rights reserved.
 * Created on 2021-08-30
 */
package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 删除状态
 * @date 2021/9/15
 * @Notice 无
 */
@Getter
@AllArgsConstructor
public enum DelFlagEnum implements BaseEnum {

    /**
     * 正常
     */
    NORMAL("0", "正常"),

    /**
     * 删除
     */
    DELETED("1", "删除");
    /**
     * 代码
     */
    private String code;
    /**
     * 描述
     */
    private String message;

    public static String getValue(String code) {
        for (DelFlagEnum res : DelFlagEnum.values()) {
            if (res.getCode().equals(code)) {
                return res.getMessage();
            }
        }
        return null;
    }


}
