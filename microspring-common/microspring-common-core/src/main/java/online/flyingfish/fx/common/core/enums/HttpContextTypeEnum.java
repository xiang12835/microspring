/**
 * All rights reserved.
 * Created on 2021-09-09
 */
package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description
 * @date 2021-09-09
 * @Version V1.0
 * @Notice
 */
@Getter
@AllArgsConstructor
public enum HttpContextTypeEnum implements BaseEnum {
    APPLICATION_JSON("APPLICATION_JSON", "application/json; charset=utf-8"),
    NOT_SUPPORT("NOT_SUPPORT", "");

    private String code;
    private String message;

    public static HttpContextTypeEnum to(String contentTypeCode) {
        if (APPLICATION_JSON.getCode().equals(contentTypeCode)) {
            return APPLICATION_JSON;
        }
        return NOT_SUPPORT;
    }
}
