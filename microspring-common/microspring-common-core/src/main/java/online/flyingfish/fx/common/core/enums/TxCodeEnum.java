/**
 * All rights reserved.
 * Created on 2021-09-18
 */
package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 交易代码
 * @date 2021-09-26
 * @Version V1.0
 * @Notice
 */
@Getter
@AllArgsConstructor
public enum TxCodeEnum {

    TXCODE_06("010106","交易代码010106"),

    TXCODE_08("010108","交易代码010108"),

    TXCODE_09("010109","交易代码010109"),

    TXCODE_24("010124","交易代码010124"),

    ;

    private String code;

    private String message;

}
