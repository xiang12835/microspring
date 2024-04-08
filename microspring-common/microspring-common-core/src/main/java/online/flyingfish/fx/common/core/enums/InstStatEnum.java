/**
 * All rights reserved.
 * Created on 2021-11-12
 */
package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 机构状态枚举类
 * @date 2021-11-12
 * @Version V1.0
 * @Notice
 */
@Getter
@AllArgsConstructor
public enum InstStatEnum {

    NORMAL_STATUS_02("02"),
    NORMAL_STATUS_03("03"),
    ;

    private String code;
}
