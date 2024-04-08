/**
 * All rights reserved.
 * Created on 2021-10-18
 */
package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 签约状态
 * @date 2021-10-18
 * @Version V1.0
 * @Notice
 */
@Getter
@AllArgsConstructor
public enum SignStatusEnum {

    /**
     * 签约
     */
    SIGNED("0", "签约"),

    /**
     * 解约
     */
    UNSIGN("1", "解约"),
    ;
    /**
     * 代码
     */
    private String code;
    /**
     * 描述
     */
    private String message;
}
