/**
 * All rights reserved.
 * Created on 2021-09-26
 */
package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 柜员是否启用标识
 * @date 2021-09-26
 * @Version V1.0
 * @Notice
 */
@Getter
@AllArgsConstructor
public enum TellerEnableFlag {

    ENABLE_FLAG_1("1","是否启用标识1"),

    ENABLE_FLAG_2("2","是否启用标识2"),

    ENABLE_FLAG_3("3","是否启用标识2"),

    ;

    private String code;

    private String message;
}
