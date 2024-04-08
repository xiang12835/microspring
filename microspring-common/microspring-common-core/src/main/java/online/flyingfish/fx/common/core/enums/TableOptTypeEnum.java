/**
 * All rights reserved.
 * Created on 2021-09-28
 */
package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 表操作类型枚举
 * @date 2021-09-28
 * @Version V1.0
 * @Notice
 */
@Getter
@AllArgsConstructor
public enum TableOptTypeEnum {
    /**
     * 新增表记录
     */
    ADD("1", "新增表记录"),

    /**
     * 更新表记录
     */
    UPDATE("2", "更新表记录");
    /**
     * 代码
     */
    private String code;
    /**
     * 描述
     */
    private String message;
}
