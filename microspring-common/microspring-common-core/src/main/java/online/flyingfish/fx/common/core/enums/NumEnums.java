/**
 * All rights reserved.
 * Created on 2021-09-04
 */
package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 数字枚举
 * @date 2021-09-04
 * @Version V1.0
 * @Notice
 */
@Getter
@AllArgsConstructor
public enum NumEnums {

    ZERO("0", 0),
    ONE("1", 1),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),

    HUNDRED("100", 100),
    TWO_HUNDRED("200", 200),
    TWO_HUNDRED_FIFTY("250", 250),
    NULL_STRING("", 0),
    ;

    private String code;
    private Integer value;
}
