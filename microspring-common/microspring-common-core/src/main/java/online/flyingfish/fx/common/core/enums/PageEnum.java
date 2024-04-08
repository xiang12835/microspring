/**
 * All rights reserved.
 * Created on 2021-09-02
 */
package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @Description page分页设置
 * @date 2021-09-02
 * @Version V1.0
 * @Notice
 */
@Getter
@AllArgsConstructor
public enum PageEnum {

    /**
     * 页面值的下限
     */
    SIZE_MIN(0),
    /**
     * 页面值的上限
     */
    SIZE_MAX(100),
    /**
     * 页面值的初始值
     */
    SIZE_INIT(10),
    /**
     * 页数的下限
     */
    INDEX_MIN(0),
    ;
    private final int num;
}
