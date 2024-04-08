/**
 * All rights reserved.
 * Created on 2021-10-21
 */
package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description EDB文件名称枚举
 * @date 2021-10-21
 * @Version V1.0
 * @Notice
 */
@Getter
@AllArgsConstructor
public enum EdbDataNameEnum {
    TELLER_INFO("99700060000", "99710900000_611120"),
    INST_INFO("99700050000", "JGQL"),
    ;

    private String sendSysCode;
    private String dataName;
}
