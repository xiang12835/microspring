/**
 * All rights reserved.
 * Created on 2021-09-02
 */
package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 角色代码
 * @date 2021-09-02
 * @Version V1.0
 * @Notice
 */
@Getter
@AllArgsConstructor
public enum RoleCodeEnum {
    /**
     * 系统管理员
     */
    SYSMANAGE("1", "系统管理员"),
    /**
     * 业务管理员
     */
    BIZMANAGE("2", "业务管理员"),
    /**
     * 操作员
     */
    OPERATOR("3", "操作员");

    /**
     * 角色代码
     */
    private final String roleCode;

    /**
     * 角色名称
     */
    private final String roleName;
}
