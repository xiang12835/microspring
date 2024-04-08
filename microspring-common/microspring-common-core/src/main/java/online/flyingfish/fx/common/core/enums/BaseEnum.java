package online.flyingfish.fx.common.core.enums;

/**
 * 基础枚举接口定义类
 *
 * @version 1.0
 * @filename BaseExceptionEnum.java
 * @date 2020-10-09
 */
public interface BaseEnum {

    /**
     * 枚举代码值
     */
    String getCode();

    /**
     * 枚举值说明
     */
    String getMessage();


    default String getDesc(){
        return getMessage();
    }

}