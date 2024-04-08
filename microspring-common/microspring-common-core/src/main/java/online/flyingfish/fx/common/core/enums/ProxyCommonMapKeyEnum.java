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
public enum ProxyCommonMapKeyEnum implements BaseEnum {
    /**
     * http模块
     */
    HTTP_METHOD("HTTP_METHOD", "HTTP请求类型"),
    HTTP_HEADER_CONTENT_TYPE("HTTP_HEADER_CONTENT_TYPE", "HTTP请求头contentType"),
    HTTP_URL_PATH_PREFIX_CODE("HTTP_URL_PATH_PREFIX_CODE", "HTTP地址路径前缀编码"),
    HTTP_URL_PATH("HTTP_URL_PATH", "HTTP地址路径"),
    HTTP_REQUEST_CALL_TIMEOUT("HTTP_REQUEST_CALL_TIMEOUT", "接口请求调用超时时间"),

    /**
     * 挡板模块
     */
    DUMMY_ENABLE("DUMMY_ENABLE", "挡板开关");


    ProxyCommonMapKeyEnum(String code, String message) {
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
