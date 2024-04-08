/**
 * All rights reserved.
 * Created on 2021-10-28
 */
package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 数据库操作类型
 * @date 2021-10-28
 * @Version V1.0
 * @Notice
 */
@Getter
@AllArgsConstructor
public enum DataBaseOprTypeEnum implements BaseEnum {
    /**
     * 插入
     */
    INSERT("INSERT", "插入数据库"),
    /**
     * 修改
     */
    UPDATE("UPDATE", "更新数据库"),
    /**
     * 插入和修改
     */
    INSERT_UPDATE("INSERT_UPDATE", "更新数据库"),
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
