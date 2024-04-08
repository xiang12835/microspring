/**
 * All rights reserved.
 * Created on 2021-10-11
 */
package online.flyingfish.fx.common.core.util;

import online.flyingfish.fx.common.core.enums.BaseEnum;

/**
 * @version V1.0
 * @Description 枚举工具类
 * @date 2021年10月11日
 * @notice
 */
public class EnumUtil {
    /**
     * 通过code值获取message值
     * @date 2021/10/11
     * @param code 枚举值
     * @param t 枚举类名
     * @Notice 无
     */
    public static <T extends BaseEnum>  String getByCode(String code, Class<T> t){
        for(T item : t.getEnumConstants()){
            if (StringUtils.equals(item.getCode(), code)){
                return item.getMessage();
            }
        }

        return "";
    }
}
