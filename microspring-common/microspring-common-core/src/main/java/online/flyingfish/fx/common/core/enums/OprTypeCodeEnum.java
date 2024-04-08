package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用于定义参数管理的操作类型代码信息
 *
 * @Date 2020/10/12
 * @Since 1.0.0
 */

@Getter
@AllArgsConstructor
public enum OprTypeCodeEnum {
    /**
     * 新增
     */
    ADD("A", "新增"),
    /**
     * 修改
     */
    UPDATE("U", "修改"),
    /**
     * 删除
     */
    DELETE("D", "删除"),
    /**
     * 文件导入
     */
    FILE("F", "文件导入");


    /**
     * 操作类型代码
     */
    private final String oprTypeCode;

    /**
     * 操作类型名称
     */
    private final String oprTypeName;
}
