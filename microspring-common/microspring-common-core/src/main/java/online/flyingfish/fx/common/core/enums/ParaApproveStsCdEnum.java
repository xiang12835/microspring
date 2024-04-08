/**
 * All rights reserved.
 * Created on 2021-09-26
 */
package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 参数审批状态代码
 * @date 2021-09-26
 * @Version V1.0
 * @Notice
 */
@Getter
@AllArgsConstructor
public enum ParaApproveStsCdEnum {

    PARA_APPROVE_STS_CD_0("0","待审批"),

    PARA_APPROVE_STS_CD_1("1","通过"),

    PARA_APPROVE_STS_CD_2("2","不通过"),

    ;

    private String code;

    private String message;
}
