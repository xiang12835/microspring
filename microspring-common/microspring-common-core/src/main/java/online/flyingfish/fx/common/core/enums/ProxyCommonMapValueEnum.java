/**
 * All rights reserved.
 * Created on 2021-09-09
 */
package online.flyingfish.fx.common.core.enums;

/**
 * @Description
 * @date 2021-09-09
 * @Version V1.0
 * @Notice
 */
public enum ProxyCommonMapValueEnum implements BaseEnum {
    /**
     * http模块
     */
    HTTP_METHOD_POST("HTTP_METHOD_POST", "POST"),
    HTTP_METHOD_GET("HTTP_METHOD_GET", "GET"),
    HTTP_HEADER_CONTENT_TYPE_JSON("HTTP_HEADER_CONTENT_TYPE_JSON", "application/json"),

    /**
     * 挡板模块
     */
    DUMMY_ENABLED("1", "挡板打开")
    ;
    ProxyCommonMapValueEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }


    private String code;
    private String message;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
