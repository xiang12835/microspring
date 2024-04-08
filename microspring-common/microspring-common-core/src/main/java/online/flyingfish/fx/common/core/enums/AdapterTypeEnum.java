package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 适配器类型枚举类
 *
 * @date 2020/9/27
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum AdapterTypeEnum {
    RESTFUL("restful", "restfullAdapter"),
    ESB("esb", "esbAdapter"),
    DUMMY("dummy", "dummyAdapter");
    /**
     * 适配器类型
     */
    private final String type;
    /**
     * 适配器Bean Name
     */
    private final String adapterName;

    /**
     * 根据适配器类型获取适配器Bean Name
     *
     * @param type 适配器类型
     * @return
     */
    public static String getAdapterNameByType(String type) {
        for (AdapterTypeEnum enums : AdapterTypeEnum.values()) {
            if (enums.getType().equals(type)) {
                return enums.getAdapterName();
            }
        }
        return "";
    }
}
